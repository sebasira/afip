package ar.com.system.afip.wsaa.business.impl;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import javax.inject.Provider;

public class HomoRetrofitProvider extends BaseRetrofitProvider {
    public HomoRetrofitProvider(Provider<XmlSerializer> xmlSerializerProvider,
                                Provider<XmlPullParser> xmlPullParserProvider) {
        super(xmlSerializerProvider,
                xmlPullParserProvider,
                "https://wsaahomo.afip.gov.ar/ws/services");
    }
}
