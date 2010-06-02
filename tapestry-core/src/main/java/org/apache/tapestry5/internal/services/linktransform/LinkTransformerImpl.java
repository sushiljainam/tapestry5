// Copyright 2010 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.tapestry5.internal.services.linktransform;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.ioc.annotations.Primary;
import org.apache.tapestry5.services.ComponentEventRequestParameters;
import org.apache.tapestry5.services.PageRenderRequestParameters;
import org.apache.tapestry5.services.linktransform.AssetLinkTransformer;
import org.apache.tapestry5.services.linktransform.ComponentEventLinkTransformer;
import org.apache.tapestry5.services.linktransform.LinkTransformer;
import org.apache.tapestry5.services.linktransform.PageRenderLinkTransformer;

public class LinkTransformerImpl implements LinkTransformer
{
    private final AssetLinkTransformer assetLinkTransformer;

    private final ComponentEventLinkTransformer componentEventLinkTransformer;

    private final PageRenderLinkTransformer pageRenderLinkTransformer;

    public LinkTransformerImpl(@Primary
    AssetLinkTransformer assetLinkTransformer, @Primary
    ComponentEventLinkTransformer componentEventLinkTransformer, @Primary
    PageRenderLinkTransformer pageRenderLinkTransformer)
    {
        this.assetLinkTransformer = assetLinkTransformer;
        this.componentEventLinkTransformer = componentEventLinkTransformer;
        this.pageRenderLinkTransformer = pageRenderLinkTransformer;
    }

    public Link transformAssetLink(Link defaultLink, Asset asset, String assetPath)
    {
        return or(assetLinkTransformer.transformAssetLink(defaultLink, asset, assetPath), defaultLink);
    }

    public Link transformComponentEventLink(Link defaultLink, ComponentEventRequestParameters parameters)
    {
        return or(componentEventLinkTransformer.transformComponentEventLink(defaultLink, parameters), defaultLink);
    }

    public Link tranformPageRenderLink(Link defaultLink, PageRenderRequestParameters parameters)
    {
        return or(pageRenderLinkTransformer.tranformPageRenderLink(defaultLink, parameters), defaultLink);
    }

    private Link or(Link left, Link right)
    {
        return left != null ? left : right;
    }

}
