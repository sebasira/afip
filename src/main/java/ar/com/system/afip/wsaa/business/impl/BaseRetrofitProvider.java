package ar.com.system.afip.wsaa.business.impl;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import javax.inject.Provider;

import io.github.nibiruos.retrosoap.RetroSoapFactory;
import io.github.nibiruos.retrosoap.SoapSpec;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static com.google.common.base.Preconditions.checkNotNull;


class BaseRetrofitProvider implements Provider<Retrofit> {
    private final Provider<XmlSerializer> xmlSerializerProvider;
    private final Provider<XmlPullParser> xmlPullParserProvider;
    private final String baseUrl;

    BaseRetrofitProvider(Provider<XmlSerializer> xmlSerializerProvider,
                         Provider<XmlPullParser> xmlPullParserProvider,
                         String baseUrl) {
        this.xmlSerializerProvider = checkNotNull(xmlSerializerProvider);
        this.xmlPullParserProvider = checkNotNull(xmlPullParserProvider);
        this.baseUrl = checkNotNull(baseUrl);
    }

    @Override
    public Retrofit get() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(RetroSoapFactory
                        .create(SimpleXmlConverterFactory.create(new Persister(new AnnotationStrategy())),
                                xmlSerializerProvider,
                                xmlPullParserProvider,
                                SoapSpec.V_1_2))
                .build();
    }
}
