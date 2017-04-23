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

package ca.paullalonde.gocd.sns_plugin.executors;

import ca.paullalonde.gocd.sns_plugin.utils.Field;
import ca.paullalonde.gocd.sns_plugin.utils.NonBlankField;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * TODO: add any additional configuration fields here.
 */
public class GetPluginConfigurationExecutor implements RequestExecutor {

    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static final Field TOPIC = new NonBlankField("topic", "Topic ARN", null, true, false, "0");
    public static final Field REGION = new Field("region", "Region", "us-east-1", false, false, "1");
    public static final Field AWS_ACCESS_ID = new Field("aws_access_id", "AWS Access ID", null, false, false, "2");
    public static final Field AWS_SECRET_ACCESS_ID = new Field("aws_secret_access_id", "AWS Secret Access ID", null, false, false, "3");

    public static final Map<String, Field> FIELDS = new LinkedHashMap<>();

    static {
        FIELDS.put(TOPIC.key(), TOPIC);
        FIELDS.put(REGION.key(), REGION);
        FIELDS.put(AWS_ACCESS_ID.key(), AWS_ACCESS_ID);
        FIELDS.put(AWS_SECRET_ACCESS_ID.key(), AWS_SECRET_ACCESS_ID);
    }

    public GoPluginApiResponse execute() {
        return new DefaultGoPluginApiResponse(200, GSON.toJson(FIELDS));
    }
}
