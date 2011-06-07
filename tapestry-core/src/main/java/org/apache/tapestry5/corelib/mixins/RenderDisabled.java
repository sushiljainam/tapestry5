// Copyright 2006, 2007, 2011 The Apache Software Foundation
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

package org.apache.tapestry5.corelib.mixins;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.MixinAfter;

/**
 * Renders an "disabled" attribute if the containing {@link Field#isDisabled() is disabled}.
 * 
 * @tapestrydoc
 */
@MixinAfter
public class RenderDisabled
{
    @InjectContainer
    private Field field;

    void beginRender(MarkupWriter writer)
    {
        if (field.isDisabled())
            writer.attributes("disabled", "disabled");
    }
}
