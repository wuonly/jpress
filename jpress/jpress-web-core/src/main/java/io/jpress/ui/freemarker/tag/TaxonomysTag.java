/**
 * Copyright (c) 2015-2016, Michael Yang 杨福海 (fuhai999@gmail.com).
 *
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jpress.ui.freemarker.tag;

import java.math.BigInteger;
import java.util.List;

import io.jpress.core.render.freemarker.JTag;
import io.jpress.model.Taxonomy;
import io.jpress.model.query.TaxonomyQuery;

public class TaxonomysTag extends JTag {

	@Override
	public void onRender() {

		int count = getParamToInt("count", 0);
		count = count <= 0 ? 10 : count;

		String module = getParam("module");
		String type = getParam("type");
		String orderby = getParam("orderby");

		BigInteger parentId = getParamToBigInteger("parentid");

		List<Taxonomy> list = TaxonomyQuery.me().findListByModuleAndType(module, type, orderby, parentId, count);
		setVariable("taxonomys", list);
		renderBody();
	}

}
