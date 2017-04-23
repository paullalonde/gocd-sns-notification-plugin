# SNS Notification Plugin

This is a GoCD Notification Plugin that forwards notifications to the AWS Simple Notification Service (SNS).

SNS is AWS' publish/subscribe subsystem. This plugin allows any piece of software that can subscribe to an SNS topic to become the recipient of GoCD notifications.

## Settings

The plugin is configurable via these settings:

* **Topic ARN** This is the SNS topic to publish notifications to. It is required.
* **Region** The AWS region in which to make SNS requests. Optional.
* **AWS Access ID** Credentials to use when accessing SNS. Optional.
* **AWS Secret Access ID** Credentials to use when accessing SNS. Optional.

The settings **AWS Access ID** and **AWS Secret Access ID** should be used for **testing purposes only**. If absent, the plugin will use the normal credential lookup mechanism as explained [here](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html).

## Building the code base

To build the jar, run `./gradlew clean test assemble`

## License

```plain
Copyright 2017 Paul Lalonde enrg.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
