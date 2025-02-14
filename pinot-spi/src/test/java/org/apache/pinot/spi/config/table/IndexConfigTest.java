/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.spi.config.table;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.pinot.spi.utils.JsonUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class IndexConfigTest {

  @Test
  public void withEmptyConf()
      throws JsonProcessingException {
    String confStr = "{}";
    IndexConfig config = JsonUtils.stringToObject(confStr, IndexConfig.class);

    assertTrue(config.isEnabled(), "Unexpected enabled");
  }

  @Test
  public void withEnabledNull()
      throws JsonProcessingException {
    String confStr = "{\"enabled\": null}";
    IndexConfig config = JsonUtils.stringToObject(confStr, IndexConfig.class);

    assertTrue(config.isEnabled(), "Unexpected enabled");
  }

  @Test
  public void withEnabledTrue()
      throws JsonProcessingException {
    String confStr = "{\"enabled\": true}";
    IndexConfig config = JsonUtils.stringToObject(confStr, IndexConfig.class);

    assertTrue(config.isEnabled(), "Unexpected enabled");
  }

  @Test
  public void withEnabledFalse()
      throws JsonProcessingException {
    String confStr = "{\"enabled\": false}";
    IndexConfig config = JsonUtils.stringToObject(confStr, IndexConfig.class);

    assertFalse(config.isEnabled(), "Unexpected enabled");
  }

  @Test
  public void withSomeData()
      throws JsonProcessingException {
    String confStr = "{\n"
        + "        \"version\": 42\n"
        + "}";
    IndexConfig config = JsonUtils.stringToObject(confStr, IndexConfig.class);

    assertTrue(config.isEnabled(), "Unexpected enabled");
  }
}
