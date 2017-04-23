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

import ca.paullalonde.gocd.sns_plugin.PluginSettings;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PluginSettingsTest {
    @Test
    public void shouldDeserializeFromJSON() throws Exception {
        PluginSettings pluginSettings = PluginSettings.fromJSON("{" +
            "\"topic\": \"arn:aws:sns:us-east-1:333333333333:my-test-topic\", " +
            "\"region\": \"us-east-1\", " +
            "\"aws_access_id\": \"my-access-id\", " +
            "\"aws_secret_access_id\": \"my-secret-access-id\" " +
            "}");

        assertThat(pluginSettings.getTopic(), is("arn:aws:sns:us-east-1:333333333333:my-test-topic"));
        assertThat(pluginSettings.getRegion(), is("us-east-1"));
        assertThat(pluginSettings.getAwsAccessId(), is("my-access-id"));
        assertThat(pluginSettings.getAwsSecretAccessId(), is("my-secret-access-id"));
    }
}
