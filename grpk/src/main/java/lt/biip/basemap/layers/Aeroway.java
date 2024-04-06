package lt.biip.basemap.layers;

import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.ForwardingProfile;
import com.onthegomap.planetiler.reader.SourceFeature;

public class Aeroway implements ForwardingProfile.FeatureProcessor {

    @Override
    public void processFeature(SourceFeature sf, FeatureCollector features) {
        if (sf.getSource().equals("grpk") && sf.getSourceLayer().startsWith("PLOTAI") && sf.canBePolygon()) {
            var code = sf.getString("GKODAS");

            switch (code) {
                case "va1" -> addFeature("aerodrome", sf, features);
                case "va11" -> addFeature("runway", sf, features);
                case "va12" -> addFeature("helipad", sf, features);
            }
        }
    }


    public void addFeature(String attrClass, SourceFeature sf, FeatureCollector features) {
        features.polygon("aeroway")
                .setAttr("class", attrClass)
                .setMinZoom(10)
                .setMinPixelSize(2);
    }
}