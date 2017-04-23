/*
 * Copyright 2017 Paul Lalonde enrg.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.paullalonde.gocd.sns_plugin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Implement any settings that your plugin needs
public class PluginSettings {
    private static final Gson GSON = new GsonBuilder().
            excludeFieldsWithoutExposeAnnotation().
            create();

    @Expose
    @SerializedName("topic")
    private String topic;

    @Expose
    @SerializedName("region")
    private String region;

    @Expose
    @SerializedName("aws_access_id")
    private String aws_access_id;

    @Expose
    @SerializedName("aws_secret_access_id")
    private String aws_secret_access_id;

    public static PluginSettings fromJSON(String json) {
        return GSON.fromJson(json, PluginSettings.class);
    }

    public String getTopic() {
        return topic;
    }

    public String getRegion() {
        return region;
    }

    public String getAwsAccessId() {
        return aws_access_id;
    }

    public String getAwsSecretAccessId() {
        return aws_secret_access_id;
    }
}
