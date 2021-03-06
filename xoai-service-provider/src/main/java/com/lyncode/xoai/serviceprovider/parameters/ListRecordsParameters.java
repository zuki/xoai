/**
 * Copyright 2012 Lyncode
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     client://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lyncode.xoai.serviceprovider.parameters;

import java.util.Date;

public class ListRecordsParameters {
    public static ListRecordsParameters request() {
        return new ListRecordsParameters();
    }

    private String metadataPrefix;
    private String setSpec;
    private Date from;
    private Date until;

    public String getMetadataPrefix() {
        return metadataPrefix;
    }

    public ListRecordsParameters withMetadataPrefix(String metadataPrefix) {
        this.metadataPrefix = metadataPrefix;
        return this;
    }

    public String getSetSpec() {
        return setSpec;
    }

    public ListRecordsParameters withSetSpec(String setSpec) {
        this.setSpec = setSpec;
        return this;
    }

    public Date getFrom() {
        return from;
    }

    public ListRecordsParameters withFrom(Date from) {
        this.from = from;
        return this;
    }

    public Date getUntil() {
        return until;
    }

    public ListRecordsParameters withUntil(Date until) {
        this.until = until;
        return this;
    }

    public boolean areValid() {
        return metadataPrefix != null;
    }
}
