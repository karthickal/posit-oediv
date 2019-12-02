# oediV - Video reimagined
This repository was created as part of a submission for Google's #AndroidDevChallenge.

![making videos interactive everywhere](./resources/cover_image.jpg)

## The Idea

#### Summary
Oediv displays relevant and contextual information in realtime over videos. By adding an interactive layer over videos, the user can engage with the video in a lot of unique ways including and not limited to - 

* Discovering similar products from the video for sale (fashion, food, electronics, etc).
* Following people on social media platforms.

#### On Device Learning

Realtime annotation is achieved by using a custom lightweight deep learning model deployed on the user's device. The model can detect and track objects locally, and relies on the backend to identify the object using data from a feature layer. This approach allows us to create interactions over videos that are - 
* Instant and works in real-time
* Does not require internet; works offline
* Prevents data piracy by not transferring the video to the server for processing.

#### Workflow

1. A custom SSD model deployed on the device detects objects of interest in the video frame
2. An auto-encoder model extracts features of the detected objects 
3. The extracted features are matched for similarity either from 
   1. a local database containing a minimal catalog of products that is trending (or)
   2. from the backend server (uses internet)

#### So far

* Launched a web app to understand user behaviour and get initial feedback. Please see - [Web Demo](http://www.justplay.tv/watch/1). Play the video and pause anywhere to explore the products used. Note that this demo does not leverage on device machine learning and displays products only when the video is paused.
* Alpha version of SDK available on Android. The SDK is currently under test with an Indian video publisher app. The SDK does not incorporate on device learning. Check out our [SDK Documentation](../master/resources/posit_sdk_doc.pdf) for more details.   

## The Plan

#### Timeline

##### December 2019

1. A working prototype that uses on device machine learning to detect apparel objects.
2. Product Roadmap.

##### January 2020

1. Improved prototype that extract features of the objects on the device.
2. UI and UX Plan.
3. Acquire dataset for training.

##### March 2020

1. Fully trained models.
2. Beta version of the product.

##### April 2020

1. Production mode.

#### Distribution Plan

* Without Google's support, especially because Android does not have an API for a 3rd party app to listen to video events and share frames, we plan to be available as a plugin for video publishers to integrate into their Android/iOs app. This means only videos streamed via our distribution partners are interactive.

#### Dataset Plan

* By partnering with e-commerce vendors for qualified traffic.
* By on-boarding influencers and content creators to allow face identification.

#### Google's Support 

* Make our tech a part of Android OS so that we can make all videos interactive instead of just those that are played from our distribution partners. This includes videos that are
  * played locally
  * streamed/played via an app
  
* Access to the Google Shopping Ads data as an API so that we can display products for sale to users. This will help us become globally available instantly by eliminating the need to partner with e-commerce vendors independently.
* Engineering Mentorship to improve detections under occlusions, different viewpoints and other complexities 
 
## About Us

#### The Development Team

* Udhaya Kumar - Android Developer 
* Shiddharth Saran - Python Developer  
* Somasundaram M - Machine Learning Engineer
* Jailany M - React Developer
* Manju R - Visual Design
* Karthick L - Product

#### Our Startup

We are a startup working on redefining the way videos are consumed today. For more information please check - www.posit.tech


