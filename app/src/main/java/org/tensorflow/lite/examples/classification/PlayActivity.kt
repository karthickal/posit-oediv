package org.tensorflow.lite.examples.classification

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Log
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_player.*

class PlayActivity : Fragment() {

    private var player: SimpleExoPlayer? = null
    private lateinit var mediaDataSourceFactory: DataSource.Factory

    private var trackSelector: DefaultTrackSelector? = null
    private var lastSeenTrackGroupArray: TrackGroupArray? = null
    private val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory()
    private var currentWindow: Int = 0

    private var playbackPosition: Long = 0
    private var playWhenReady: Boolean = true

    private val LOG_TAG = "PlayActivity"

    private var videoId: String? = null
    private var title: String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_player, container, false)
        return view
    }

    private fun initializePlayer() {

        trackSelector = DefaultTrackSelector(requireContext(), videoTrackSelectionFactory)
        mediaDataSourceFactory = DefaultDataSourceFactory(requireContext(), Util.getUserAgent(requireContext(), "justplayTV"))

//        var sourceUrl = "https://s3.ap-south-1.amazonaws.com/testing.deliver.videos.justplay.tv/titles/aval-anthathi/mobile/output/media.m3u8"
//        var videoId = 123
//        var fps = 24
        title = "Time Travel Machine"
        val sourceUrl = "https://s3.ap-south-1.amazonaws.com/testing.deliver.videos.justplay.tv/titles/short-films/time-travel/mobile/output/media.m3u8"
        val fps = 24

        val hlsMediaSource = HlsMediaSource.Factory(mediaDataSourceFactory).createMediaSource(Uri.parse(sourceUrl))

        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(requireContext(), trackSelector!!)
            player?.prepare(hlsMediaSource, false, false)
        }

        player_view.setShutterBackgroundColor(Color.TRANSPARENT)
        player_view.player = player
        player_view.requestFocus()
        player?.playWhenReady = this.playWhenReady
        player_view.useController = false

//        ivHideControllerButton.setOnClickListener { playerView.hideController() }

        Log.d(LOG_TAG, "Registering the player with Posit")
        if (playbackPosition > 0) {
            player?.seekTo(currentWindow, playbackPosition)
        }
        player_view.useController = true
        lastSeenTrackGroupArray = null
    }


    private fun updateStartPosition() {

        playbackPosition = player?.currentPosition ?: 0
        currentWindow = player?.currentWindowIndex ?: 0
        playWhenReady = player?.playWhenReady ?: true
        Log.d(LOG_TAG, "Updating position $playbackPosition playready $playWhenReady window $currentWindow")
    }

    private fun releasePlayer() {
        updateStartPosition()
        player?.release()
        player = null
        trackSelector = null
    }

    public override fun onStart() {
        super.onStart()

        Log.d(LOG_TAG, "Activity Started")
        initializePlayer()

        player_view.onResume()
    }

    public override fun onResume() {
        super.onResume()

        Log.d(LOG_TAG, "Activity Resumed")


//        initializePlayer()
//        if (Util.SDK_INT <= 23) initializePlayer()
    }

    public override fun onPause() {
        super.onPause()
        updateStartPosition()

        Log.d(LOG_TAG, "Activity Paused")

        if (Util.SDK_INT <= 23) releasePlayer()
    }

    public override fun onStop() {
        super.onStop()
//        updateStartPosition()
        Log.d(LOG_TAG, "Activity Stopped")

        if (Util.SDK_INT > 23) releasePlayer()
    }
}

