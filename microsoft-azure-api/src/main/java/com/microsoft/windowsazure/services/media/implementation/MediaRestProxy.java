/**
 * Copyright 2011 Microsoft Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microsoft.windowsazure.services.media.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.microsoft.windowsazure.services.core.ServiceFilter;
import com.microsoft.windowsazure.services.core.utils.pipeline.ClientFilterAdapter;
import com.microsoft.windowsazure.services.media.MediaContract;
import com.microsoft.windowsazure.services.media.models.Asset;
import com.microsoft.windowsazure.services.media.models.ListAssetsOptions;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class MediaRestProxy implements MediaContract {

    private Client channel;
    static Log log = LogFactory.getLog(MediaContract.class);

    ServiceFilter[] filters;

    @Inject
    public MediaRestProxy(Client channel, OAuthFilter authFilter, RedirectFilter redirectFilter) {
        this.channel = channel;
        this.filters = new ServiceFilter[0];
        channel.addFilter(redirectFilter);
        channel.addFilter(authFilter);
    }

    public MediaRestProxy(Client channel, ServiceFilter[] filters) {
        this.channel = channel;
        this.filters = filters;
    }

    @Override
    public MediaContract withFilter(ServiceFilter filter) {
        ServiceFilter[] newFilters = Arrays.copyOf(filters, filters.length + 1);
        newFilters[filters.length] = filter;
        return new MediaRestProxy(channel, newFilters);
    }

    public Client getChannel() {
        return channel;
    }

    public void setChannel(Client channel) {
        this.channel = channel;
    }

    private WebResource getResource(String entityName) {
        WebResource resource = getChannel().resource(entityName);
        for (ServiceFilter filter : filters) {
            resource.addFilter(new ClientFilterAdapter(filter));
        }
        return resource;
    }

    @Override
    public Asset createAsset(Asset asset) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Asset getAsset(Asset asset) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Asset> listAssets(ListAssetsOptions listAssetsOptions) {
        List<Asset> listAssetsResult = new ArrayList<Asset>();
        return listAssetsResult;
    }

    @Override
    public Asset updateAsset(Asset updatedAsset) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAsset(String assetId) {
        // TODO Auto-generated method stub

    }

}
