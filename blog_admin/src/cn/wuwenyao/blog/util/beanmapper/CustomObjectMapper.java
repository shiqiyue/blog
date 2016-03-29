/*******************************************************************************
 * Copyright (c) 2005, 2014 zzy.cn
 *
 * 
 *******************************************************************************/
package cn.wuwenyao.blog.util.beanmapper;

import java.io.IOException;

import org.springframework.web.util.HtmlUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * 自定义jackson 对象 映射（增加 xss过滤）
 * 
 * @author lll 2015年2月5日
 */
public class CustomObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = -3448961813323784217L;

	public CustomObjectMapper() {
		SimpleModule module = new SimpleModule("HTML XSS Serializer",
				new Version(1, 0, 0, "FINAL", "com.yihaomen", "ep-jsonmodule"));
		module.addSerializer(new JsonHtmlXssSerializer(String.class));
		module.addDeserializer(String.class, new JsonHtmlXssDeserializer());
		this.registerModule(module);
	}
	
	/**
	 * json String 自定义反序列化（htmlEscape）
	 * @author lll 2015年2月5日
	 */
	class JsonHtmlXssDeserializer extends JsonDeserializer<String> {

		@Override
		public String deserialize(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			JsonNode node = jp.getCodec().readTree(jp);  
	        String text = HtmlUtils.htmlEscape(node.asText());
	        return text;  
		}
	}

	/**
	 * json String 自定义序列化（htmlUnescape）
	 * @author lll 2015年2月5日
	 */
	class JsonHtmlXssSerializer extends JsonSerializer<String> {

		public JsonHtmlXssSerializer(Class<String> string) {
			super();
		}

		public Class<String> handledType() {
			return String.class;
		}

		@Override
		public void serialize(String value, JsonGenerator jsonGenerator,
				SerializerProvider serializerProvider) throws IOException,
				JsonProcessingException {
			if (value != null) {
				String encodedValue = HtmlUtils.htmlUnescape(value.toString());
				jsonGenerator.writeString(encodedValue);
			}
		}
	}
}
