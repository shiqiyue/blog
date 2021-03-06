package cn.wuwenyao.blog.sitemesh.tag.ruleBundle;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

public class JSRuleBundle implements TagRuleBundle {

	@Override
	public void install(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
		defaultState.addRule("frontpagejs",
				new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("frontpagejs"), false));
		defaultState.addRule("backpagejs",
				new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("backpagejs"), false));
	}

	@Override
	public void cleanUp(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
		// TODO Auto-generated method stub

	}

}
