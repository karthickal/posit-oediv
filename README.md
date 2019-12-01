# oediV - Videos re-imagined
This repository was created as part of a submission for Google's #AndroidDevChallenge.

COVER IMAGE HERE

## The Idea

#### Summary
Oediv displays relevant and contextual information in realtime over videos. By adding an interactive layer over videos, the user can engage with the video in a lot of unique ways including and not limited to - 

* Discovering products for sale (fashion, food, electronics, etc).
* Following people on social media platforms.

#### On Device Learning

Realtime annotations is achieved by using a custom lightweight deep learning model deployed on the user's device. The model can detect and track objects locally, and relies on the backend to identify the object using data from a feature layer. This approach allows us to create interactions over videos that are - 
* Instant and works in real-time
* Does not require internet; works offline
* Prevents data piracy by not transferring the video to the server for processing.     

## The Plan

* December 15 2019 - A working prototype that can detect people and apparels in a video.
* January 15 2020 - Finalize UI/UX.
* January 31, 2020 - Improve the model with an encoding layer to identify the product from a catalog of items in the backend.
* March 31, 2020 - Tested working product (standalone app, sdk for distribution)

#### Distribution Plan

* Without Google's support, especially because Android does not have an API for a 3rd party app to listen to video events and share frames, our plan is to be available as a plugin for video publishers to integrate in their Android/iOs app. This means only videos streamed via our distribution partners are interactive.

#### Datasource Plan

* By partnering with e-commerce vendors for qualified traffic.
* By on-boarding celebrities and content creators to allow face identification.

#### Google's Support 

* Make our tech a part of Android OS so that we can make all videos interactive instead of just those that are played from our distribution partners.
* Expose the Google Shopping Ads data as an API so that we can display products for sale to our users. This will help us become globally available instantly by eliminating the need to partner with e-commerce vendors independently. 
 
## About Us





