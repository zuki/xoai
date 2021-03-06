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

package com.lyncode.xoai.dataprovider.repository;

import com.lyncode.xoai.model.oaipmh.DeletedRecord;
import com.lyncode.xoai.model.oaipmh.Granularity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

public class RepositoryConfiguration {
    private String repositoryName;
    private List<String> adminEmails = new ArrayList<String>();
    private String baseUrl;
    private Date earliestDate;
    private int maxListIdentifiers;
    private int maxListSets;
    private int maxListRecords;
    private Granularity granularity;
    private DeletedRecord deleteMethod;
    private List<String> descriptions;
    private List<String> compressions;

    public String getRepositoryName() {
        return repositoryName;
    }

    public List<String> getAdminEmails() {
        return adminEmails;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Date getEarliestDate() {
        return earliestDate;
    }

    public int getMaxListIdentifiers() {
        return this.maxListIdentifiers;
    }

    public int getMaxListSets() {
        return this.maxListSets;
    }

    public int getMaxListRecords() {
        return this.maxListRecords;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public DeletedRecord getDeleteMethod() {
        return deleteMethod;
    }

    public List<String> getDescription() {
        return descriptions;
    }

    public List<String> getCompressions () {
        return compressions;
    }

    public RepositoryConfiguration withMaxListSets(int maxListSets) {
        this.maxListSets = maxListSets;
        return this;
    }

    public RepositoryConfiguration withGranularity(Granularity granularity) {
        this.granularity = granularity;
        return this;
    }

    public RepositoryConfiguration withRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
        return this;
    }

    public RepositoryConfiguration and () {
        return this;
    }

    public RepositoryConfiguration withAdminEmails(String... emails) {
        this.adminEmails.addAll(asList(emails));
        return this;
    }

    public RepositoryConfiguration withAdminEmail(String email) {
        this.adminEmails.add(email);
        return this;
    }
    public RepositoryConfiguration withDeleteMethod(DeletedRecord deleteMethod) {
        this.deleteMethod = deleteMethod;
        return this;
    }

    public RepositoryConfiguration withDescription(String description) {
        if (descriptions == null)
            descriptions = new ArrayList<String>();
        descriptions.add(description);
        return this;
    }

    public RepositoryConfiguration withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public RepositoryConfiguration withEarliestDate(Date earliestDate) {
        this.earliestDate = earliestDate;
        return this;
    }

    public RepositoryConfiguration withCompression (String compression) {
        if (compressions == null)
            compressions = new ArrayList<String>();
        compressions.add(compression);
        return this;
    }

    public RepositoryConfiguration withMaxListRecords(int maxListRecords) {
        this.maxListRecords = maxListRecords;
        return this;
    }

    public RepositoryConfiguration withDefaults () {
        this.repositoryName = "Repository";
        this.earliestDate = new Date();
        this.adminEmails.add("sample@test.com");
        this.baseUrl = "http://localhost";
        this.maxListIdentifiers = 100;
        this.maxListRecords = 100;
        this.maxListSets = 100;
        this.granularity = Granularity.Second;
        this.deleteMethod = DeletedRecord.NO;

        return this;
    }

    public boolean hasCompressions() {
        return compressions != null && !compressions.isEmpty();
    }

    public RepositoryConfiguration withMaxListIdentifiers(int maxListIdentifiers) {
        this.maxListIdentifiers = maxListIdentifiers;
        return this;
    }
}
