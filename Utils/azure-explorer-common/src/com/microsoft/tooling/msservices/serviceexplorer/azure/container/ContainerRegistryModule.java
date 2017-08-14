/**
 * Copyright (c) Microsoft Corporation
 * <p/>
 * All rights reserved.
 * <p/>
 * MIT License
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.microsoft.tooling.msservices.serviceexplorer.azure.container;

import com.microsoft.azuretools.azurecommons.helpers.AzureCmdException;
import com.microsoft.azuretools.core.mvp.ui.base.NodeContent;
import com.microsoft.tooling.msservices.serviceexplorer.AzureRefreshableNode;
import com.microsoft.tooling.msservices.serviceexplorer.Node;
import com.microsoft.tooling.msservices.serviceexplorer.azure.rediscache.RedisCacheNode;

public class ContainerRegistryModule extends AzureRefreshableNode {

    private static final String ACR_MODULE_ID = ContainerRegistryModule.class.getName();
    //TODO: need icon here
    private static final String ICON_PATH = "RedisCache.png";
    private static final String BASE_MODULE_NAME = "Azure Container Registry";
    private final ContainerRegistryModulePresenter<ContainerRegistryModule> containerRegistryPresenter;

    public ContainerRegistryModule(Node parent) {
        super(ACR_MODULE_ID, BASE_MODULE_NAME, parent, ICON_PATH);
        containerRegistryPresenter = new ContainerRegistryModulePresenter<>();
        containerRegistryPresenter.onAttachView(ContainerRegistryModule.this);
    }

    @Override
    public ContainerRegistryNode createNode(Node parent, String sid, NodeContent content) {
        return new ContainerRegistryNode(this, sid, content);
    }

    @Override
    protected void refreshItems() throws AzureCmdException {
        containerRegistryPresenter.onModuleRefresh();
    }

}