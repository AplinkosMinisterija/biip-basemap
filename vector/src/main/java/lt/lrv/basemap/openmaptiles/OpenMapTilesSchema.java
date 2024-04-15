package lt.lrv.basemap.openmaptiles;

/*
Copyright (c) 2021, MapTiler.com & OpenMapTiles contributors.
All rights reserved.

Code license: BSD 3-Clause License

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.

* Neither the name of the copyright holder nor the names of its
  contributors may be used to endorse or promote products derived from
  this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

Design license: CC-BY 4.0

See https://github.com/openmaptiles/openmaptiles/blob/master/LICENSE.md for details on usage
*/
// DO NOT MODIFY: fetch newer version from https://github.com/openmaptiles/planetiler-openmaptiles/blob/main/src/main/java/org/openmaptiles/generated/OpenMapTilesSchema.java

import static com.onthegomap.planetiler.expression.Expression.*;
import com.onthegomap.planetiler.expression.MultiExpression;

import java.util.List;
import java.util.Set;


/**
 * All vector tile layer definitions, attributes, and allowed values generated from the
 * <a href="https://github.com/openmaptiles/openmaptiles/blob/master/openmaptiles.yaml">OpenMapTiles vector tile schema
 * master</a>.
 */
@SuppressWarnings("unused")
public class OpenMapTilesSchema {
    public static final String NAME = "OpenMapTiles";
    public static final String DESCRIPTION = "A tileset showcasing all layers in OpenMapTiles. https://openmaptiles.org";
    public static final String VERSION = "3.14.0";
    public static final String ATTRIBUTION =
            "<a href=\"https://www.openmaptiles.org/\" target=\"_blank\">&copy; OpenMapTiles</a> <a href=\"https://www.openstreetmap.org/copyright\" target=\"_blank\">&copy; OpenStreetMap contributors</a>";
    public static final List<String> LANGUAGES = List.of("am", "ar", "az", "be", "bg", "bn", "br", "bs", "ca", "co", "cs",
            "cy", "da", "de", "el", "en", "eo", "es", "et", "eu", "fa", "fi", "fr", "fy", "ga", "gd", "he", "hi", "hr", "hu",
            "hy", "id", "is", "it", "ja", "ja_kana", "ja_rm", "ja-Latn", "ja-Hira", "ka", "kk", "kn", "ko", "ko-Latn", "ku",
            "la", "lb", "lt", "lv", "mk", "mt", "ml", "nl", "no", "oc", "pa", "pnb", "pl", "pt", "rm", "ro", "ru", "sk", "sl",
            "sq", "sr", "sr-Latn", "sv", "ta", "te", "th", "tr", "uk", "ur", "vi", "zh", "zh-Hant", "zh-Hans");


    /**
     * Water polygons representing oceans and lakes. Covered watered areas are excluded (<code>covered=yes</code>). On low
     * zoom levels all water originates from Natural Earth. To get a more correct display of the south pole you should
     * also style the covering ice shelves over the water. On higher zoom levels water polygons from
     * <a href="http://osmdata.openstreetmap.de/">OpenStreetMapData</a> are used. The polygons are split into many smaller
     * polygons to improve rendering performance. This however can lead to less rendering options in clients since these
     * boundaries show up. So you might not be able to use border styling for ocean water features.
     * <p>
     * Generated from
     * <a href="https://github.com/openmaptiles/openmaptiles/blob/master/layers/water/water.yaml">water.yaml</a>
     */
    public interface Water extends Layer {
        double BUFFER_SIZE = 4.0;
        String LAYER_NAME = "water";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the water layer.
         */
        final class Fields {
            /**
             * From zoom 6 are taken OSM IDs. Up to zoom 5 there are used Natural Earth lakes, where are propagated the OSM
             * IDs insted of Natural Earth IDs. For smaller area then planet, NE lakes keep their Natural Earth IDs.
             */
            public static final String ID = "id";

            /**
             * All water polygons from <a href="http://osmdata.openstreetmap.de/">OpenStreetMapData</a> have the class
             * <code>ocean</code>. The water-covered areas of flowing water bodies with the
             * <a href="http://wiki.openstreetmap.org/wiki/Tag:water=river"><code>water=river</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Tag:water=canal"><code>water=canal</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Tag:water=stream"><code>water=stream</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Tag:water=ditch"><code>water=ditch</code></a>, or
             * <a href="http://wiki.openstreetmap.org/wiki/Tag:water=drain"><code>water=drain</code></a> tags are classified
             * as river. Wet and dry docks tagged
             * <a href="http://wiki.openstreetmap.org/wiki/Tag:waterway=dock"><code>waterway=dock</code></a> are classified as
             * a <code>dock</code>. Various minor waterbodies are classified as a <code>pond</code>. Swimming pools tagged
             * <a href="https://wiki.openstreetmap.org/wiki/Tag:leisure=swimming_pool"><code>leisure=swimming_pool</code></a>
             * are classified as a <code>swimming_pool</code> All other water bodies are classified as <code>lake</code>.
             * <p>
             * allowed values:
             * <ul>
             * <li>dock
             * <li>river
             * <li>pond
             * <li>lake
             * <li>ocean
             * <li>swimming_pool
             * </ul>
             */
            public static final String CLASS = "class";

            /**
             * Mark with <code>1</code> if it is an
             * <a href="http://wiki.openstreetmap.org/wiki/Key:intermittent">intermittent</a> water polygon.
             * <p>
             * allowed values:
             * <ul>
             * <li>0
             * <li>1
             * </ul>
             */
            public static final String INTERMITTENT = "intermittent";

            /**
             * Identifies the type of crossing as either a bridge or a tunnel.
             * <p>
             * allowed values:
             * <ul>
             * <li>"bridge"
             * <li>"tunnel"
             * </ul>
             */
            public static final String BRUNNEL = "brunnel";
        }

        /**
         * Attribute values for map elements in the water layer.
         */
        final class FieldValues {
            public static final String CLASS_DOCK = "dock";
            public static final String CLASS_RIVER = "river";
            public static final String CLASS_POND = "pond";
            public static final String CLASS_LAKE = "lake";
            public static final String CLASS_OCEAN = "ocean";
            public static final String CLASS_SWIMMING_POOL = "swimming_pool";
            public static final Set<String> CLASS_VALUES = Set.of("dock", "river", "pond", "lake", "ocean", "swimming_pool");
            public static final String BRUNNEL_BRIDGE = "bridge";
            public static final String BRUNNEL_TUNNEL = "tunnel";
            public static final Set<String> BRUNNEL_VALUES = Set.of("bridge", "tunnel");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the water layer.
         */
        final class FieldMappings {
            public static final MultiExpression<String> Class =
                    MultiExpression.of(List.of(MultiExpression.entry("dock", matchAny("waterway", "dock")),
                            MultiExpression.entry("river", matchAny("water", "river", "stream", "canal", "ditch", "drain")),
                            MultiExpression.entry("pond", matchAny("water", "pond", "basin", "wastewater")),
                            MultiExpression.entry("lake", FALSE), MultiExpression.entry("ocean", FALSE),
                            MultiExpression.entry("swimming_pool", matchAny("leisure", "swimming_pool"))));
        }
    }

    /**
     * OpenStreetMap <a href="https://wiki.openstreetmap.org/wiki/Waterways">waterways</a> for higher zoom levels (z9 and
     * more) and Natural Earth rivers and lake centerlines for low zoom levels (z3 - z8). Linestrings without a name or
     * which are too short are filtered out at low zoom levels. Till z11 there is <code>river</code> class only, in z12
     * there is also <code>canal</code> generated, starting z13 there is no generalization according to <code>class</code>
     * field applied. Waterways do not have a <code>subclass</code> field.
     * <p>
     * Generated from
     * <a href="https://github.com/openmaptiles/openmaptiles/blob/master/layers/waterway/waterway.yaml">waterway.yaml</a>
     */
    public interface Waterway extends Layer {
        double BUFFER_SIZE = 4.0;
        String LAYER_NAME = "waterway";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the waterway layer.
         */
        final class Fields {
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:name"><code>name</code></a> value of the waterway.
             * Language-specific values are in <code>name:xx</code>. The <code>name</code> field may be empty for NaturalEarth
             * data or at lower zoom levels.
             */
            public static final String NAME = "name";
            /**
             * English name <code>name:en</code> if available, otherwise <code>name</code>. This is deprecated and will be
             * removed in a future release in favor of <code>name:en</code>.
             */
            public static final String NAME_EN = "name_en";
            /**
             * German name <code>name:de</code> if available, otherwise <code>name</code> or <code>name:en</code>. This is
             * deprecated and will be removed in a future release in favor of <code>name:de</code>.
             */
            public static final String NAME_DE = "name_de";

            /**
             * The original value of the <a href="http://wiki.openstreetmap.org/wiki/Key:waterway"><code>waterway</code></a>
             * tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>"stream"
             * <li>"river"
             * <li>"canal"
             * <li>"drain"
             * <li>"ditch"
             * </ul>
             */
            public static final String CLASS = "class";

            /**
             * Mark whether way is a tunnel or bridge.
             * <p>
             * allowed values:
             * <ul>
             * <li>"bridge"
             * <li>"tunnel"
             * </ul>
             */
            public static final String BRUNNEL = "brunnel";

            /**
             * Mark with <code>1</code> if it is an
             * <a href="http://wiki.openstreetmap.org/wiki/Key:intermittent">intermittent</a> waterway.
             * <p>
             * allowed values:
             * <ul>
             * <li>0
             * <li>1
             * </ul>
             */
            public static final String INTERMITTENT = "intermittent";
        }

        /**
         * Attribute values for map elements in the waterway layer.
         */
        final class FieldValues {
            public static final String CLASS_STREAM = "stream";
            public static final String CLASS_RIVER = "river";
            public static final String CLASS_CANAL = "canal";
            public static final String CLASS_DRAIN = "drain";
            public static final String CLASS_DITCH = "ditch";
            public static final Set<String> CLASS_VALUES = Set.of("stream", "river", "canal", "drain", "ditch");
            public static final String BRUNNEL_BRIDGE = "bridge";
            public static final String BRUNNEL_TUNNEL = "tunnel";
            public static final Set<String> BRUNNEL_VALUES = Set.of("bridge", "tunnel");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the waterway layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * Landcover is used to describe the physical material at the surface of the earth. At lower zoom levels this is from
     * Natural Earth data for glaciers and ice shelves and at higher zoom levels the landcover is
     * <a href="http://wiki.openstreetmap.org/wiki/Landcover">implied by OSM tags</a>. The most common use case for this
     * layer is to style wood (<code>class=wood</code>) and grass (<code>class=grass</code>) areas.
     * <p>
     * Generated from <a href=
     * "https://github.com/openmaptiles/openmaptiles/blob/master/layers/landcover/landcover.yaml">landcover.yaml</a>
     */
    public interface Landcover extends Layer {
        double BUFFER_SIZE = 4.0;
        String LAYER_NAME = "landcover";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the landcover layer.
         */
        final class Fields {
            /**
             * Use the <strong>class</strong> to assign natural colors for <strong>landcover</strong>.
             * <p>
             * allowed values:
             * <ul>
             * <li>farmland
             * <li>ice
             * <li>wood
             * <li>rock
             * <li>grass
             * <li>wetland
             * <li>sand
             * </ul>
             */
            public static final String CLASS = "class";

            /**
             * Use <strong>subclass</strong> to do more precise styling. Original value of either the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:natural"><code>natural</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:landuse"><code>landuse</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:leisure"><code>leisure</code></a>, or
             * <a href="http://wiki.openstreetmap.org/wiki/Key:wetland"><code>wetland</code></a> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>"allotments"
             * <li>"bare_rock"
             * <li>"beach"
             * <li>"bog"
             * <li>"dune"
             * <li>"scrub"
             * <li>"shrubbery"
             * <li>"farm"
             * <li>"farmland"
             * <li>"fell"
             * <li>"forest"
             * <li>"garden"
             * <li>"glacier"
             * <li>"grass"
             * <li>"grassland"
             * <li>"golf_course"
             * <li>"heath"
             * <li>"mangrove"
             * <li>"marsh"
             * <li>"meadow"
             * <li>"orchard"
             * <li>"park"
             * <li>"plant_nursery"
             * <li>"recreation_ground"
             * <li>"reedbed"
             * <li>"saltern"
             * <li>"saltmarsh"
             * <li>"sand"
             * <li>"scree"
             * <li>"swamp"
             * <li>"tidalflat"
             * <li>"tundra"
             * <li>"village_green"
             * <li>"vineyard"
             * <li>"wet_meadow"
             * <li>"wetland"
             * <li>"wood"
             * </ul>
             */
            public static final String SUBCLASS = "subclass";
        }

        /**
         * Attribute values for map elements in the landcover layer.
         */
        final class FieldValues {
            public static final String CLASS_FARMLAND = "farmland";
            public static final String CLASS_ICE = "ice";
            public static final String CLASS_WOOD = "wood";
            public static final String CLASS_ROCK = "rock";
            public static final String CLASS_GRASS = "grass";
            public static final String CLASS_WETLAND = "wetland";
            public static final String CLASS_SAND = "sand";
            public static final Set<String> CLASS_VALUES =
                    Set.of("farmland", "ice", "wood", "rock", "grass", "wetland", "sand");
            public static final String SUBCLASS_ALLOTMENTS = "allotments";
            public static final String SUBCLASS_BARE_ROCK = "bare_rock";
            public static final String SUBCLASS_BEACH = "beach";
            public static final String SUBCLASS_BOG = "bog";
            public static final String SUBCLASS_DUNE = "dune";
            public static final String SUBCLASS_SCRUB = "scrub";
            public static final String SUBCLASS_SHRUBBERY = "shrubbery";
            public static final String SUBCLASS_FARM = "farm";
            public static final String SUBCLASS_FARMLAND = "farmland";
            public static final String SUBCLASS_FELL = "fell";
            public static final String SUBCLASS_FOREST = "forest";
            public static final String SUBCLASS_GARDEN = "garden";
            public static final String SUBCLASS_GLACIER = "glacier";
            public static final String SUBCLASS_GRASS = "grass";
            public static final String SUBCLASS_GRASSLAND = "grassland";
            public static final String SUBCLASS_GOLF_COURSE = "golf_course";
            public static final String SUBCLASS_HEATH = "heath";
            public static final String SUBCLASS_MANGROVE = "mangrove";
            public static final String SUBCLASS_MARSH = "marsh";
            public static final String SUBCLASS_MEADOW = "meadow";
            public static final String SUBCLASS_ORCHARD = "orchard";
            public static final String SUBCLASS_PARK = "park";
            public static final String SUBCLASS_PLANT_NURSERY = "plant_nursery";
            public static final String SUBCLASS_RECREATION_GROUND = "recreation_ground";
            public static final String SUBCLASS_REEDBED = "reedbed";
            public static final String SUBCLASS_SALTERN = "saltern";
            public static final String SUBCLASS_SALTMARSH = "saltmarsh";
            public static final String SUBCLASS_SAND = "sand";
            public static final String SUBCLASS_SCREE = "scree";
            public static final String SUBCLASS_SWAMP = "swamp";
            public static final String SUBCLASS_TIDALFLAT = "tidalflat";
            public static final String SUBCLASS_TUNDRA = "tundra";
            public static final String SUBCLASS_VILLAGE_GREEN = "village_green";
            public static final String SUBCLASS_VINEYARD = "vineyard";
            public static final String SUBCLASS_WET_MEADOW = "wet_meadow";
            public static final String SUBCLASS_WETLAND = "wetland";
            public static final String SUBCLASS_WOOD = "wood";
            public static final Set<String> SUBCLASS_VALUES =
                    Set.of("allotments", "bare_rock", "beach", "bog", "dune", "scrub", "shrubbery", "farm", "farmland", "fell",
                            "forest", "garden", "glacier", "grass", "grassland", "golf_course", "heath", "mangrove", "marsh", "meadow",
                            "orchard", "park", "plant_nursery", "recreation_ground", "reedbed", "saltern", "saltmarsh", "sand", "scree",
                            "swamp", "tidalflat", "tundra", "village_green", "vineyard", "wet_meadow", "wetland", "wood");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the landcover layer.
         */
        final class FieldMappings {
            public static final MultiExpression<String> Class =
                    MultiExpression
                            .of(List.of(
                                    MultiExpression.entry("farmland",
                                            matchAny("subclass", "farmland", "farm", "orchard", "vineyard", "plant_nursery")),
                                    MultiExpression.entry("ice", matchAny("subclass", "glacier", "ice_shelf")),
                                    MultiExpression.entry("wood", matchAny("subclass", "wood", "forest")),
                                    MultiExpression.entry("rock", matchAny("subclass", "bare_rock", "scree")),
                                    MultiExpression.entry("grass",
                                            matchAny("subclass", "fell", "grassland", "heath", "scrub", "shrubbery", "tundra", "grass", "meadow",
                                                    "allotments", "park", "village_green", "recreation_ground", "garden", "golf_course")),
                                    MultiExpression.entry("wetland",
                                            matchAny("subclass", "wetland", "bog", "swamp", "wet_meadow", "marsh", "reedbed", "saltern", "tidalflat",
                                                    "saltmarsh", "mangrove")),
                                    MultiExpression.entry("sand", matchAny("subclass", "beach", "sand", "dune"))));
        }
    }

    /**
     * Landuse is used to describe use of land by humans. At lower zoom levels this is from Natural Earth data for
     * residential (urban) areas and at higher zoom levels mostly OSM <code>landuse</code> tags.
     * <p>
     * Generated from
     * <a href="https://github.com/openmaptiles/openmaptiles/blob/master/layers/landuse/landuse.yaml">landuse.yaml</a>
     */
    public interface Landuse extends Layer {
        double BUFFER_SIZE = 4.0;
        String LAYER_NAME = "landuse";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the landuse layer.
         */
        final class Fields {
            /**
             * Use the <strong>class</strong> to assign special colors to areas. Original value of either the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:landuse"><code>landuse</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:amenity"><code>amenity</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:leisure"><code>leisure</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:tourism"><code>tourism</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:place"><code>place</code></a> or
             * <a href="http://wiki.openstreetmap.org/wiki/Key:waterway"><code>waterway</code></a> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>"railway"
             * <li>"cemetery"
             * <li>"military"
             * <li>"residential"
             * <li>"commercial"
             * <li>"industrial"
             * <li>"garages"
             * <li>"retail"
             * <li>"bus_station"
             * <li>"school"
             * <li>"university"
             * <li>"kindergarten"
             * <li>"college"
             * <li>"library"
             * <li>"hospital"
             * <li>"stadium"
             * <li>"pitch"
             * <li>"playground"
             * <li>"track"
             * <li>"theme_park"
             * <li>"zoo"
             * <li>"suburb"
             * <li>"quarter"
             * <li>"neighbourhood"
             * <li>"dam"
             * <li>"quarry"
             * </ul>
             */
            public static final String CLASS = "class";
        }

        /**
         * Attribute values for map elements in the landuse layer.
         */
        final class FieldValues {
            public static final String CLASS_RAILWAY = "railway";
            public static final String CLASS_CEMETERY = "cemetery";
            public static final String CLASS_MILITARY = "military";
            public static final String CLASS_RESIDENTIAL = "residential";
            public static final String CLASS_COMMERCIAL = "commercial";
            public static final String CLASS_INDUSTRIAL = "industrial";
            public static final String CLASS_GARAGES = "garages";
            public static final String CLASS_RETAIL = "retail";
            public static final String CLASS_BUS_STATION = "bus_station";
            public static final String CLASS_SCHOOL = "school";
            public static final String CLASS_UNIVERSITY = "university";
            public static final String CLASS_KINDERGARTEN = "kindergarten";
            public static final String CLASS_COLLEGE = "college";
            public static final String CLASS_LIBRARY = "library";
            public static final String CLASS_HOSPITAL = "hospital";
            public static final String CLASS_STADIUM = "stadium";
            public static final String CLASS_PITCH = "pitch";
            public static final String CLASS_PLAYGROUND = "playground";
            public static final String CLASS_TRACK = "track";
            public static final String CLASS_THEME_PARK = "theme_park";
            public static final String CLASS_ZOO = "zoo";
            public static final String CLASS_SUBURB = "suburb";
            public static final String CLASS_QUARTER = "quarter";
            public static final String CLASS_NEIGHBOURHOOD = "neighbourhood";
            public static final String CLASS_DAM = "dam";
            public static final String CLASS_QUARRY = "quarry";
            public static final Set<String> CLASS_VALUES =
                    Set.of("railway", "cemetery", "military", "residential", "commercial", "industrial", "garages", "retail",
                            "bus_station", "school", "university", "kindergarten", "college", "library", "hospital", "stadium", "pitch",
                            "playground", "track", "theme_park", "zoo", "suburb", "quarter", "neighbourhood", "dam", "quarry");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the landuse layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * <a href="http://wiki.openstreetmap.org/wiki/Tag:natural%3Dpeak">Natural peaks</a>
     * <p>
     * Generated from <a href=
     * "https://github.com/openmaptiles/openmaptiles/blob/master/layers/mountain_peak/mountain_peak.yaml">mountain_peak.yaml</a>
     */
    public interface MountainPeak extends Layer {
        double BUFFER_SIZE = 64.0;
        String LAYER_NAME = "mountain_peak";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the mountain_peak layer.
         */
        final class Fields {
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:name"><code>name</code></a> value of the peak.
             * Language-specific values are in <code>name:xx</code>.
             */
            public static final String NAME = "name";
            /**
             * English name <code>name:en</code> if available, otherwise <code>name</code>. This is deprecated and will be
             * removed in a future release in favor of <code>name:en</code>.
             */
            public static final String NAME_EN = "name_en";
            /**
             * German name <code>name:de</code> if available, otherwise <code>name</code> or <code>name:en</code>.
             */
            public static final String NAME_DE = "name_de";

            /**
             * Use the <strong>class</strong> to differentiate between natural objects.
             * <p>
             * allowed values:
             * <ul>
             * <li>"peak"
             * <li>"volcano"
             * <li>"saddle"
             * <li>"ridge"
             * <li>"cliff"
             * <li>"arete"
             * </ul>
             */
            public static final String CLASS = "class";
            /**
             * Elevation (<code>ele</code>) in meters.
             */
            public static final String ELE = "ele";
            /**
             * Elevation (<code>ele</code>) in feet.
             */
            public static final String ELE_FT = "ele_ft";

            /**
             * Value 1 for peaks in location where feet is used as customary unit (USA).
             * <p>
             * allowed values:
             * <ul>
             * <li>1
             * <li>null
             * </ul>
             */
            public static final String CUSTOMARY_FT = "customary_ft";
            /**
             * Rank of the peak within one tile (starting at 1 that is the most important peak).
             */
            public static final String RANK = "rank";
        }

        /**
         * Attribute values for map elements in the mountain_peak layer.
         */
        final class FieldValues {
            public static final String CLASS_PEAK = "peak";
            public static final String CLASS_VOLCANO = "volcano";
            public static final String CLASS_SADDLE = "saddle";
            public static final String CLASS_RIDGE = "ridge";
            public static final String CLASS_CLIFF = "cliff";
            public static final String CLASS_ARETE = "arete";
            public static final Set<String> CLASS_VALUES = Set.of("peak", "volcano", "saddle", "ridge", "cliff", "arete");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the mountain_peak layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * The park layer in OpenMapTiles contains natural and protected areas from OpenStreetMap, such as parks tagged with
     * <a href="https://wiki.openstreetmap.org/wiki/Tag:boundary%3Dnational_park"><code>boundary=national_park</code></a>,
     * <a href=
     * "https://wiki.openstreetmap.org/wiki/Tag:boundary%3Dprotected_area"><code>boundary=protected_area</code></a>, or
     * <a href="https://wiki.openstreetmap.org/wiki/Tag:leisure%3Dnature_reserve"><code>leisure=nature_reserve</code></a>.
     * <p>
     * Generated from
     * <a href="https://github.com/openmaptiles/openmaptiles/blob/master/layers/park/park.yaml">park.yaml</a>
     */
    public interface Park extends Layer {
        double BUFFER_SIZE = 4.0;
        String LAYER_NAME = "park";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the park layer.
         */
        final class Fields {
            /**
             * Use the <strong>class</strong> to differentiate between different kinds of features in the <code>parks</code>
             * layer. The class for <code>boundary=protected_area</code> parks is the lower-case of the
             * <a href="http://wiki.openstreetmap.org/wiki/key:protection_title"><code>protection_title</code></a> value with
             * blanks replaced by <code>_</code>. <code>national_park</code> is the class of
             * <code>protection_title=National Park</code> and <code>boundary=national_park</code>.
             * <code>nature_reserve</code> is the class of <code>protection_title=Nature Reserve</code> and
             * <code>leisure=nature_reserve</code>. The class for other
             * <a href="http://wiki.openstreetmap.org/wiki/key:protection_title"><code>protection_title</code></a> values is
             * similarly assigned.
             */
            public static final String CLASS = "class";
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:name"><code>name</code></a> value of the park (point
             * features only). Language-specific values are in <code>name:xx</code>.
             */
            public static final String NAME = "name";
            /**
             * English name <code>name:en</code> if available, otherwise <code>name</code> (point features only). This is
             * deprecated and will be removed in a future release in favor of <code>name:en</code>.
             */
            public static final String NAME_EN = "name_en";
            /**
             * German name <code>name:de</code> if available, otherwise <code>name</code> or <code>name:en</code> (point
             * features only). This is deprecated and will be removed in a future release in favor of <code>name:de</code>.
             */
            public static final String NAME_DE = "name_de";
            /**
             * Rank of the park within one tile, starting at 1 that is the most important park (point features only).
             */
            public static final String RANK = "rank";
        }

        /**
         * Attribute values for map elements in the park layer.
         */
        final class FieldValues {

        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the park layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * Contains administrative boundaries as linestrings and aboriginal lands as polygons. Until z4
     * <a href="http://www.naturalearthdata.com/downloads/">Natural Earth data</a> is used after which OSM boundaries
     * (<a href=
     * "http://wiki.openstreetmap.org/wiki/Tag:boundary%3Dadministrative"><code>boundary=administrative</code></a>) are
     * present from z5 to z14 (also for maritime boundaries with <code>admin_level &lt;= 2</code> at z4). OSM data
     * contains several
     * <a href="http://wiki.openstreetmap.org/wiki/Tag:boundary%3Dadministrative#admin_level"><code>admin_level</code></a>
     * but for most styles it makes sense to just style <code>admin_level=2</code> and <code>admin_level=4</code>.
     * <p>
     * Generated from
     * <a href="https://github.com/openmaptiles/openmaptiles/blob/master/layers/boundary/boundary.yaml">boundary.yaml</a>
     */
    public interface Boundary extends Layer {
        double BUFFER_SIZE = 4.0;
        String LAYER_NAME = "boundary";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the boundary layer.
         */
        final class Fields {
            /**
             * Use the <strong>class</strong> to differentiate between different kinds of boundaries. The class for
             * <code>boundary=aboriginal_lands</code> is <code>aboriginal_lands</code>.
             */
            public static final String CLASS = "class";
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:name"><code>name</code></a> value (area features only).
             */
            public static final String NAME = "name";
            /**
             * OSM <a href="http://wiki.openstreetmap.org/wiki/Tag:boundary%3Dadministrative#admin_level">admin_level</a>
             * indicating the level of importance of this boundary. The <code>admin_level</code> corresponds to the lowest
             * <code>admin_level</code> the line participates in. At low zoom levels the Natural Earth boundaries are mapped
             * to the equivalent admin levels.
             */
            public static final String ADMIN_LEVEL = "admin_level";
            /**
             * State name on the left of the border. For country boundaries only (<code>admin_level = 2</code>).
             */
            public static final String ADM0_L = "adm0_l";
            /**
             * State name on the right of the border. For country boundaries only (<code>admin_level = 2</code>).
             */
            public static final String ADM0_R = "adm0_r";

            /**
             * Mark with <code>1</code> if the border is disputed.
             * <p>
             * allowed values:
             * <ul>
             * <li>0
             * <li>1
             * </ul>
             */
            public static final String DISPUTED = "disputed";

            /**
             * Field containing name of the disputed area (extracted from border relation in OSM, without spaces). For country
             * boundaries only (<code>admin_level = 2</code>). Value examples from Asian OSM pbf extract
             * <p>
             * allowed values:
             * <ul>
             * <li>"AbuMusaIsland"
             * <li>"BaraHotiiValleys"
             * <li>"ChineseClaim"
             * <li>"Crimea"
             * <li>"Demchok"
             * <li>"Dokdo"
             * <li>"IndianClaim-North"
             * <li>"IndianClaimwesternKashmir"
             * <li>"PakistaniClaim"
             * <li>"SamduValleys"
             * <li>"TirpaniValleys"
             * </ul>
             */
            public static final String DISPUTED_NAME = "disputed_name";
            /**
             * ISO2 code of country, which wants to see the boundary line. For country boundaries only
             * (<code>admin_level = 2</code>).
             */
            public static final String CLAIMED_BY = "claimed_by";

            /**
             * Mark with <code>1</code> if it is a maritime border.
             * <p>
             * allowed values:
             * <ul>
             * <li>0
             * <li>1
             * </ul>
             */
            public static final String MARITIME = "maritime";
        }

        /**
         * Attribute values for map elements in the boundary layer.
         */
        final class FieldValues {
            public static final String DISPUTED_NAME_ABUMUSAISLAND = "AbuMusaIsland";
            public static final String DISPUTED_NAME_BARAHOTIIVALLEYS = "BaraHotiiValleys";
            public static final String DISPUTED_NAME_CHINESECLAIM = "ChineseClaim";
            public static final String DISPUTED_NAME_CRIMEA = "Crimea";
            public static final String DISPUTED_NAME_DEMCHOK = "Demchok";
            public static final String DISPUTED_NAME_DOKDO = "Dokdo";
            public static final String DISPUTED_NAME_INDIANCLAIM_NORTH = "IndianClaim-North";
            public static final String DISPUTED_NAME_INDIANCLAIMWESTERNKASHMIR = "IndianClaimwesternKashmir";
            public static final String DISPUTED_NAME_PAKISTANICLAIM = "PakistaniClaim";
            public static final String DISPUTED_NAME_SAMDUVALLEYS = "SamduValleys";
            public static final String DISPUTED_NAME_TIRPANIVALLEYS = "TirpaniValleys";
            public static final Set<String> DISPUTED_NAME_VALUES =
                    Set.of("AbuMusaIsland", "BaraHotiiValleys", "ChineseClaim", "Crimea", "Demchok", "Dokdo", "IndianClaim-North",
                            "IndianClaimwesternKashmir", "PakistaniClaim", "SamduValleys", "TirpaniValleys");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the boundary layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * Aeroway polygons based of OpenStreetMap <a href="http://wiki.openstreetmap.org/wiki/Aeroways">aeroways</a>. Airport
     * buildings are contained in the <strong>building</strong> layer but all other airport related polygons can be found
     * in the <strong>aeroway</strong> layer.
     * <p>
     * Generated from
     * <a href="https://github.com/openmaptiles/openmaptiles/blob/master/layers/aeroway/aeroway.yaml">aeroway.yaml</a>
     */
    public interface Aeroway extends Layer {
        double BUFFER_SIZE = 4.0;
        String LAYER_NAME = "aeroway";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the aeroway layer.
         */
        final class Fields {
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:ref"><code>ref</code></a> tag of the runway/taxiway.
             */
            public static final String REF = "ref";

            /**
             * The original value of <a href="http://wiki.openstreetmap.org/wiki/Key:aeroway"><code>aeroway</code></a> or
             * <code>area:aeroway</code> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>"aerodrome"
             * <li>"heliport"
             * <li>"runway"
             * <li>"helipad"
             * <li>"taxiway"
             * <li>"apron"
             * <li>"gate"
             * </ul>
             */
            public static final String CLASS = "class";
        }

        /**
         * Attribute values for map elements in the aeroway layer.
         */
        final class FieldValues {
            public static final String CLASS_AERODROME = "aerodrome";
            public static final String CLASS_HELIPORT = "heliport";
            public static final String CLASS_RUNWAY = "runway";
            public static final String CLASS_HELIPAD = "helipad";
            public static final String CLASS_TAXIWAY = "taxiway";
            public static final String CLASS_APRON = "apron";
            public static final String CLASS_GATE = "gate";
            public static final Set<String> CLASS_VALUES =
                    Set.of("aerodrome", "heliport", "runway", "helipad", "taxiway", "apron", "gate");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the aeroway layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * <strong>transportation</strong> contains roads, railways, aerial ways, and shipping lines. This layer is directly
     * derived from the OSM road hierarchy. At lower zoom levels major highways from Natural Earth are used. It contains
     * all roads from motorways to primary, secondary and tertiary roads to residential roads and foot paths. Styling the
     * roads is the most essential part of the map. The <code>transportation</code> layer also contains polygons for
     * features like plazas.
     * <p>
     * Generated from <a href=
     * "https://github.com/openmaptiles/openmaptiles/blob/master/layers/transportation/transportation.yaml">transportation.yaml</a>
     */
    public interface Transportation extends Layer {
        double BUFFER_SIZE = 4.0;
        String LAYER_NAME = "transportation";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the transportation layer.
         */
        final class Fields {
            /**
             * Distinguish between more and less important roads or railways and roads under construction. Class is derived
             * from the value of the <a href="http://wiki.openstreetmap.org/wiki/Key:highway"><code>highway</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:construction"><code>construction</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:railway"><code>railway</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:aerialway"><code>aerialway</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:route"><code>route</code></a> tag (for shipping ways),
             * <a href="https://wiki.openstreetmap.org/wiki/Key:busway"><code>busway</code></a>, or
             * <a href="http://wiki.openstreetmap.org/wiki/Key:man_made"><code>man_made</code></a>.
             * <p>
             * allowed values:
             * <ul>
             * <li>motorway
             * <li>trunk
             * <li>primary
             * <li>secondary
             * <li>tertiary
             * <li>minor
             * <li>path
             * <li>service
             * <li>track
             * <li>raceway
             * <li>busway
             * <li>bus_guideway
             * <li>ferry
             * <li>motorway_construction
             * <li>trunk_construction
             * <li>primary_construction
             * <li>secondary_construction
             * <li>tertiary_construction
             * <li>minor_construction
             * <li>path_construction
             * <li>service_construction
             * <li>track_construction
             * <li>raceway_construction
             * </ul>
             */
            public static final String CLASS = "class";

            /**
             * Distinguish more specific classes of railway and path: Subclass is value of the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:railway"><code>railway</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:highway"><code>highway</code></a> (for paths), or
             * <a href="http://wiki.openstreetmap.org/wiki/Key:public_transport"><code>public_transport</code></a> (for
             * platforms) tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>"rail"
             * <li>"narrow_gauge"
             * <li>"preserved"
             * <li>"funicular"
             * <li>"subway"
             * <li>"light_rail"
             * <li>"monorail"
             * <li>"tram"
             * <li>"pedestrian"
             * <li>"path"
             * <li>"footway"
             * <li>"cycleway"
             * <li>"steps"
             * <li>"bridleway"
             * <li>"corridor"
             * <li>"platform"
             * <li>"ferry (DEPRECATED - use class)"
             * </ul>
             */
            public static final String SUBCLASS = "subclass";
            /**
             * The network type derived mainly from
             * <a href="http://wiki.openstreetmap.org/wiki/Key:network"><code>network</code></a> tag of the road. See more
             * info about <a href="http://wiki.openstreetmap.org/wiki/Road_signs_in_the_United_States"><code>us- </code></a>,
             * <a href="https://en.wikipedia.org/wiki/Trans-Canada_Highway"><code>ca-transcanada</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/United_Kingdom_Tagging_Guidelines#UK_roads"><code>gb- </code></a>,
             * or <a href="http://wiki.openstreetmap.org/wiki/Ireland/Roads"><code>ie- </code></a>.
             */
            public static final String NETWORK = "network";

            /**
             * Mark whether way is a tunnel or bridge.
             * <p>
             * allowed values:
             * <ul>
             * <li>"bridge"
             * <li>"tunnel"
             * <li>"ford"
             * </ul>
             */
            public static final String BRUNNEL = "brunnel";

            /**
             * Mark with <code>1</code> whether way is a oneway in the direction of the way, with <code>-1</code> whether way
             * is a oneway in the opposite direction of the way or not a oneway with <code>0</code>.
             * <p>
             * allowed values:
             * <ul>
             * <li>1
             * <li>-1
             * </ul>
             */
            public static final String ONEWAY = "oneway";

            /**
             * Mark with <code>1</code> whether way is a ramp (link or steps) or not with <code>0</code>.
             * <p>
             * allowed values:
             * <ul>
             * <li>1
             * </ul>
             */
            public static final String RAMP = "ramp";

            /**
             * Original value of the <a href="http://wiki.openstreetmap.org/wiki/Key:service"><code>service</code></a> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>"spur"
             * <li>"yard"
             * <li>"siding"
             * <li>"crossover"
             * <li>"driveway"
             * <li>"alley"
             * <li>"parking_aisle"
             * </ul>
             */
            public static final String SERVICE = "service";

            /**
             * Access restrictions on this road. Supported values of the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:access"><code>access</code></a> tag are <code>no</code> and
             * <code>private</code>, which resolve to <code>no</code>.
             * <p>
             * allowed values:
             * <ul>
             * <li>false
             * </ul>
             */
            public static final String ACCESS = "access";

            /**
             * Whether this is a toll road, based on the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:toll"><code>toll</code></a> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>0
             * <li>1
             * </ul>
             */
            public static final String TOLL = "toll";

            /**
             * Whether this is an expressway, based on the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:expressway"><code>expressway</code></a> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>1
             * </ul>
             */
            public static final String EXPRESSWAY = "expressway";
            /**
             * Original value of the <a href="http://wiki.openstreetmap.org/wiki/Key:layer"><code>layer</code></a> tag.
             */
            public static final String LAYER = "layer";
            /**
             * Experimental feature! Filled only for steps and footways. Original value of the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:level"><code>level</code></a> tag.
             */
            public static final String LEVEL = "level";

            /**
             * Experimental feature! Filled only for steps and footways. Original value of the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:indoor"><code>indoor</code></a> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>1
             * </ul>
             */
            public static final String INDOOR = "indoor";
            /**
             * Original value of the <a href="http://wiki.openstreetmap.org/wiki/Key:bicycle"><code>bicycle</code></a> tag
             * (highways only).
             */
            public static final String BICYCLE = "bicycle";
            /**
             * Original value of the <a href="http://wiki.openstreetmap.org/wiki/Key:foot"><code>foot</code></a> tag (highways
             * only).
             */
            public static final String FOOT = "foot";
            /**
             * Original value of the <a href="http://wiki.openstreetmap.org/wiki/Key:horse"><code>horse</code></a> tag
             * (highways only).
             */
            public static final String HORSE = "horse";
            /**
             * Original value of the <a href="http://wiki.openstreetmap.org/wiki/Key:mtb:scale"><code>mtb:scale</code></a> tag
             * (highways only).
             */
            public static final String MTB_SCALE = "mtb_scale";

            /**
             * Values of <a href="https://wiki.openstreetmap.org/wiki/Key:surface"><code>surface</code></a> tag devided into 2
             * groups <code>paved</code> (paved, asphalt, cobblestone, concrete, concrete:lanes, concrete:plates, metal,
             * paving_stones, sett, unhewn_cobblestone, wood) and <code>unpaved</code> (unpaved, compacted, dirt, earth,
             * fine_gravel, grass, grass_paver, gravel, gravel_turf, ground, ice, mud, pebblestone, salt, sand, snow,
             * woodchips).
             * <p>
             * allowed values:
             * <ul>
             * <li>"paved"
             * <li>"unpaved"
             * </ul>
             */
            public static final String SURFACE = "surface";
        }

        /**
         * Attribute values for map elements in the transportation layer.
         */
        final class FieldValues {
            public static final String CLASS_MOTORWAY = "motorway";
            public static final String CLASS_TRUNK = "trunk";
            public static final String CLASS_PRIMARY = "primary";
            public static final String CLASS_SECONDARY = "secondary";
            public static final String CLASS_TERTIARY = "tertiary";
            public static final String CLASS_MINOR = "minor";
            public static final String CLASS_PATH = "path";
            public static final String CLASS_SERVICE = "service";
            public static final String CLASS_TRACK = "track";
            public static final String CLASS_RACEWAY = "raceway";
            public static final String CLASS_BUSWAY = "busway";
            public static final String CLASS_BUS_GUIDEWAY = "bus_guideway";
            public static final String CLASS_FERRY = "ferry";
            public static final String CLASS_MOTORWAY_CONSTRUCTION = "motorway_construction";
            public static final String CLASS_TRUNK_CONSTRUCTION = "trunk_construction";
            public static final String CLASS_PRIMARY_CONSTRUCTION = "primary_construction";
            public static final String CLASS_SECONDARY_CONSTRUCTION = "secondary_construction";
            public static final String CLASS_TERTIARY_CONSTRUCTION = "tertiary_construction";
            public static final String CLASS_MINOR_CONSTRUCTION = "minor_construction";
            public static final String CLASS_PATH_CONSTRUCTION = "path_construction";
            public static final String CLASS_SERVICE_CONSTRUCTION = "service_construction";
            public static final String CLASS_TRACK_CONSTRUCTION = "track_construction";
            public static final String CLASS_RACEWAY_CONSTRUCTION = "raceway_construction";
            public static final Set<String> CLASS_VALUES =
                    Set.of("motorway", "trunk", "primary", "secondary", "tertiary", "minor", "path", "service", "track", "raceway",
                            "busway", "bus_guideway", "ferry", "motorway_construction", "trunk_construction", "primary_construction",
                            "secondary_construction", "tertiary_construction", "minor_construction", "path_construction",
                            "service_construction", "track_construction", "raceway_construction");
            public static final String SUBCLASS_RAIL = "rail";
            public static final String SUBCLASS_NARROW_GAUGE = "narrow_gauge";
            public static final String SUBCLASS_PRESERVED = "preserved";
            public static final String SUBCLASS_FUNICULAR = "funicular";
            public static final String SUBCLASS_SUBWAY = "subway";
            public static final String SUBCLASS_LIGHT_RAIL = "light_rail";
            public static final String SUBCLASS_MONORAIL = "monorail";
            public static final String SUBCLASS_TRAM = "tram";
            public static final String SUBCLASS_PEDESTRIAN = "pedestrian";
            public static final String SUBCLASS_PATH = "path";
            public static final String SUBCLASS_FOOTWAY = "footway";
            public static final String SUBCLASS_CYCLEWAY = "cycleway";
            public static final String SUBCLASS_STEPS = "steps";
            public static final String SUBCLASS_BRIDLEWAY = "bridleway";
            public static final String SUBCLASS_CORRIDOR = "corridor";
            public static final String SUBCLASS_PLATFORM = "platform";
            public static final String SUBCLASS_FERRY = "ferry";
            public static final Set<String> SUBCLASS_VALUES =
                    Set.of("rail", "narrow_gauge", "preserved", "funicular", "subway", "light_rail", "monorail", "tram",
                            "pedestrian", "path", "footway", "cycleway", "steps", "bridleway", "corridor", "platform", "ferry");
            public static final String BRUNNEL_BRIDGE = "bridge";
            public static final String BRUNNEL_TUNNEL = "tunnel";
            public static final String BRUNNEL_FORD = "ford";
            public static final Set<String> BRUNNEL_VALUES = Set.of("bridge", "tunnel", "ford");
            public static final String SERVICE_SPUR = "spur";
            public static final String SERVICE_YARD = "yard";
            public static final String SERVICE_SIDING = "siding";
            public static final String SERVICE_CROSSOVER = "crossover";
            public static final String SERVICE_DRIVEWAY = "driveway";
            public static final String SERVICE_ALLEY = "alley";
            public static final String SERVICE_PARKING_AISLE = "parking_aisle";
            public static final Set<String> SERVICE_VALUES =
                    Set.of("spur", "yard", "siding", "crossover", "driveway", "alley", "parking_aisle");
            public static final String SURFACE_PAVED = "paved";
            public static final String SURFACE_UNPAVED = "unpaved";
            public static final Set<String> SURFACE_VALUES = Set.of("paved", "unpaved");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the transportation layer.
         */
        final class FieldMappings {
            public static final MultiExpression<String> Class = MultiExpression.of(List.of(
                    MultiExpression.entry("motorway", matchAny("highway", "motorway", "motorway_link")),
                    MultiExpression.entry("trunk", matchAny("highway", "trunk", "trunk_link")),
                    MultiExpression.entry("primary", matchAny("highway", "primary", "primary_link")),
                    MultiExpression.entry("secondary", matchAny("highway", "secondary", "secondary_link")),
                    MultiExpression.entry("tertiary", matchAny("highway", "tertiary", "tertiary_link")),
                    MultiExpression.entry("minor", matchAny("highway", "unclassified", "residential", "living_street", "road")),
                    MultiExpression.entry("path",
                            or(matchAny("highway", "pedestrian", "path", "footway", "cycleway", "steps", "bridleway", "corridor"),
                                    matchAny("public_transport", "platform"))),
                    MultiExpression.entry("service", matchAny("highway", "service")),
                    MultiExpression.entry("track", matchAny("highway", "track")),
                    MultiExpression.entry("raceway", matchAny("highway", "raceway")),
                    MultiExpression.entry("busway", matchAny("highway", "busway")),
                    MultiExpression.entry("bus_guideway", matchAny("highway", "bus_guideway")),
                    MultiExpression.entry("ferry", matchAny("highway", "shipway")),
                    MultiExpression.entry("motorway_construction",
                            and(matchAny("highway", "construction"), matchAny("construction", "motorway", "motorway_link"))),
                    MultiExpression.entry("trunk_construction",
                            and(matchAny("highway", "construction"), matchAny("construction", "trunk", "trunk_link"))),
                    MultiExpression.entry("primary_construction",
                            and(matchAny("highway", "construction"), matchAny("construction", "primary", "primary_link"))),
                    MultiExpression.entry("secondary_construction",
                            and(matchAny("highway", "construction"), matchAny("construction", "secondary", "secondary_link"))),
                    MultiExpression.entry("tertiary_construction",
                            and(matchAny("highway", "construction"), matchAny("construction", "tertiary", "tertiary_link"))),
                    MultiExpression.entry("minor_construction",
                            and(matchAny("highway", "construction"),
                                    matchAny("construction", "", "unclassified", "residential", "living_street", "road"))),
                    MultiExpression.entry("path_construction",
                            and(matchAny("highway", "construction"),
                                    or(matchAny("construction", "pedestrian", "path", "footway", "cycleway", "steps", "bridleway", "corridor"),
                                            matchAny("public_transport", "platform")))),
                    MultiExpression.entry("service_construction",
                            and(matchAny("highway", "construction"), matchAny("construction", "service"))),
                    MultiExpression.entry("track_construction",
                            and(matchAny("highway", "construction"), matchAny("construction", "track"))),
                    MultiExpression.entry("raceway_construction",
                            and(matchAny("highway", "construction"), matchAny("construction", "raceway")))));
        }
    }

    /**
     * All <a href="http://wiki.openstreetmap.org/wiki/Buildings">OSM Buildings</a>. All building tags are imported
     * (<a href="http://wiki.openstreetmap.org/wiki/Key:building"><code>building= </code></a>). Only buildings with tag
     * location:underground are excluded.
     * <p>
     * Generated from
     * <a href="https://github.com/openmaptiles/openmaptiles/blob/master/layers/building/building.yaml">building.yaml</a>
     */
    public interface Building extends Layer {
        double BUFFER_SIZE = 4.0;
        String LAYER_NAME = "building";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the building layer.
         */
        final class Fields {
            /**
             * An approximated height from levels and height of the building or building:part.
             */
            public static final String RENDER_HEIGHT = "render_height";
            /**
             * An approximated height from minimum levels or minimum height of the bottom of the building or building:part.
             */
            public static final String RENDER_MIN_HEIGHT = "render_min_height";
            /**
             * Colour
             */
            public static final String COLOUR = "colour";
            /**
             * If True, building (part) should not be rendered in 3D. Currently,
             * <a href="https://wiki.openstreetmap.org/wiki/Simple_3D_buildings">building outlines</a> are marked as hide_3d.
             */
            public static final String HIDE_3D = "hide_3d";
        }

        /**
         * Attribute values for map elements in the building layer.
         */
        final class FieldValues {

        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the building layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * Lake center lines for labelling lake bodies. This is based of the
     * <a href="https://github.com/openmaptiles/osm-lakelines">osm-lakelines</a> project which derives nice centerlines
     * from OSM water bodies. Only the most important lakes contain labels.
     * <p>
     * Generated from <a href=
     * "https://github.com/openmaptiles/openmaptiles/blob/master/layers/water_name/water_name.yaml">water_name.yaml</a>
     */
    public interface WaterName extends Layer {
        double BUFFER_SIZE = 256.0;
        String LAYER_NAME = "water_name";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the water_name layer.
         */
        final class Fields {
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:name"><code>name</code></a> value of the water body.
             * Language-specific values are in <code>name:xx</code>.
             */
            public static final String NAME = "name";
            /**
             * English name <code>name:en</code> if available, otherwise <code>name</code>. This is deprecated and will be
             * removed in a future release in favor of <code>name:en</code>.
             */
            public static final String NAME_EN = "name_en";
            /**
             * German name <code>name:de</code> if available, otherwise <code>name</code> or <code>name:en</code>. This is
             * deprecated and will be removed in a future release in favor of <code>name:de</code>.
             */
            public static final String NAME_DE = "name_de";

            /**
             * Distinguish between <code>lake</code>, <code>ocean</code>, <code>bay</code>, <code>strait</code>, and
             * <code>sea</code>.
             * <p>
             * allowed values:
             * <ul>
             * <li>"lake"
             * <li>"bay"
             * <li>"strait"
             * <li>"sea"
             * <li>"ocean"
             * </ul>
             */
            public static final String CLASS = "class";

            /**
             * Mark with <code>1</code> if it is an
             * <a href="http://wiki.openstreetmap.org/wiki/Key:intermittent">intermittent</a> lake.
             * <p>
             * allowed values:
             * <ul>
             * <li>0
             * <li>1
             * </ul>
             */
            public static final String INTERMITTENT = "intermittent";
        }

        /**
         * Attribute values for map elements in the water_name layer.
         */
        final class FieldValues {
            public static final String CLASS_LAKE = "lake";
            public static final String CLASS_BAY = "bay";
            public static final String CLASS_STRAIT = "strait";
            public static final String CLASS_SEA = "sea";
            public static final String CLASS_OCEAN = "ocean";
            public static final Set<String> CLASS_VALUES = Set.of("lake", "bay", "strait", "sea", "ocean");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the water_name layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * This is the layer for labelling the highways. Only highways that are named <code>name= </code> and are long enough
     * to place text upon appear. The OSM roads are stitched together if they contain the same name to have better label
     * placement than having many small linestrings. For motorways you should use the <code>ref</code> field to label them
     * while for other roads you should use <code>name</code>.
     * <p>
     * Generated from <a href=
     * "https://github.com/openmaptiles/openmaptiles/blob/master/layers/transportation_name/transportation_name.yaml">transportation_name.yaml</a>
     */
    public interface TransportationName extends Layer {
        double BUFFER_SIZE = 8.0;
        String LAYER_NAME = "transportation_name";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the transportation_name layer.
         */
        final class Fields {
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Highways#Names_and_references"><code>name</code></a> value
             * of the highway.
             */
            public static final String NAME = "name";
            /**
             * English name <code>name:en</code> if available, otherwise <code>name</code>. This is deprecated and will be
             * removed in a future release in favor of <code>name:en</code>.
             */
            public static final String NAME_EN = "name_en";
            /**
             * German name <code>name:de</code> if available, otherwise <code>name</code> or <code>name:en</code>. This is
             * deprecated and will be removed in a future release in favor of <code>name:de</code>.
             */
            public static final String NAME_DE = "name_de";
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:ref"><code>ref</code></a> tag of the motorway or its
             * network.
             */
            public static final String REF = "ref";
            /**
             * Length of the <code>ref</code> field. Useful for having a shield icon as background for labeling motorways.
             */
            public static final String REF_LENGTH = "ref_length";

            /**
             * The network type derived mainly from
             * <a href="http://wiki.openstreetmap.org/wiki/Key:network"><code>network</code></a> tag of the road. See more
             * info about <a href="http://wiki.openstreetmap.org/wiki/Road_signs_in_the_United_States"><code>us- </code></a>,
             * <a href="https://en.wikipedia.org/wiki/Trans-Canada_Highway"><code>ca-transcanada</code></a>, or
             * <a href="http://wiki.openstreetmap.org/wiki/United_Kingdom_Tagging_Guidelines#UK_roads"><code>gb- </code></a>.
             * <p>
             * allowed values:
             * <ul>
             * <li>"us-interstate"
             * <li>"us-highway"
             * <li>"us-state"
             * <li>"ca-transcanada"
             * <li>"ca-provincial-arterial"
             * <li>"ca-provincial"
             * <li>"gb-motorway"
             * <li>"gb-trunk"
             * <li>"gb-primary"
             * <li>"ie-motorway"
             * <li>"ie-national"
             * <li>"ie-regional"
             * <li>"road (default)"
             * </ul>
             */
            public static final String NETWORK = "network";

            /**
             * Distinguish between more and less important roads and roads under construction.
             * <p>
             * allowed values:
             * <ul>
             * <li>"motorway"
             * <li>"trunk"
             * <li>"primary"
             * <li>"secondary"
             * <li>"tertiary"
             * <li>"minor"
             * <li>"service"
             * <li>"track"
             * <li>"path"
             * <li>"raceway"
             * <li>"motorway_construction"
             * <li>"trunk_construction"
             * <li>"primary_construction"
             * <li>"secondary_construction"
             * <li>"tertiary_construction"
             * <li>"minor_construction"
             * <li>"service_construction"
             * <li>"track_construction"
             * <li>"path_construction"
             * <li>"raceway_construction"
             * <li>"rail"
             * <li>"transit"
             * <li>"motorway_junction"
             * </ul>
             */
            public static final String CLASS = "class";

            /**
             * Distinguish more specific classes of path: Subclass is value of the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:highway"><code>highway</code></a> (for paths), and
             * &quot;junction&quot; for
             * <a href="http://wiki.openstreetmap.org/wiki/Tag:highway=motorway_junction"><code>motorway junctions</code></a>.
             * <p>
             * allowed values:
             * <ul>
             * <li>"pedestrian"
             * <li>"path"
             * <li>"footway"
             * <li>"cycleway"
             * <li>"steps"
             * <li>"bridleway"
             * <li>"corridor"
             * <li>"platform"
             * <li>"junction"
             * </ul>
             */
            public static final String SUBCLASS = "subclass";

            /**
             * Mark whether way is a bridge, a tunnel or a ford.
             * <p>
             * allowed values:
             * <ul>
             * <li>"bridge"
             * <li>"tunnel"
             * <li>"ford"
             * </ul>
             */
            public static final String BRUNNEL = "brunnel";
            /**
             * Experimental feature! Filled only for steps and footways. Original value of
             * <a href="http://wiki.openstreetmap.org/wiki/Key:level"><code>level</code></a> tag.
             */
            public static final String LEVEL = "level";
            /**
             * Experimental feature! Filled only for steps and footways. Original value of
             * <a href="http://wiki.openstreetmap.org/wiki/Key:layer"><code>layer</code></a> tag.
             */
            public static final String LAYER = "layer";

            /**
             * Experimental feature! Filled only for steps and footways. Original value of
             * <a href="http://wiki.openstreetmap.org/wiki/Key:indoor"><code>indoor</code></a> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>1
             * </ul>
             */
            public static final String INDOOR = "indoor";
            /**
             * 1st route concurrency network.
             */
            public static final String ROUTE_1_NETWORK = "route_1_network";
            /**
             * 1st route concurrency ref.
             */
            public static final String ROUTE_1_REF = "route_1_ref";
            /**
             * 1st route concurrency name.
             */
            public static final String ROUTE_1_NAME = "route_1_name";
            /**
             * 1st route concurrency colour.
             */
            public static final String ROUTE_1_COLOUR = "route_1_colour";
            /**
             * 2nd route concurrency network.
             */
            public static final String ROUTE_2_NETWORK = "route_2_network";
            /**
             * 2nd route concurrency ref.
             */
            public static final String ROUTE_2_REF = "route_2_ref";
            /**
             * 2nd route concurrency name.
             */
            public static final String ROUTE_2_NAME = "route_2_name";
            /**
             * 2nd route concurrency colour.
             */
            public static final String ROUTE_2_COLOUR = "route_2_colour";
            /**
             * 3rd route concurrency network.
             */
            public static final String ROUTE_3_NETWORK = "route_3_network";
            /**
             * 3rd route concurrency ref.
             */
            public static final String ROUTE_3_REF = "route_3_ref";
            /**
             * 3rd route concurrency name.
             */
            public static final String ROUTE_3_NAME = "route_3_name";
            /**
             * 3rd route concurrency colour.
             */
            public static final String ROUTE_3_COLOUR = "route_3_colour";
            /**
             * 4th route concurrency network.
             */
            public static final String ROUTE_4_NETWORK = "route_4_network";
            /**
             * 4th route concurrency ref.
             */
            public static final String ROUTE_4_REF = "route_4_ref";
            /**
             * 4th route concurrency name.
             */
            public static final String ROUTE_4_NAME = "route_4_name";
            /**
             * 4th route concurrency colour.
             */
            public static final String ROUTE_4_COLOUR = "route_4_colour";
            /**
             * 5th route concurrency network.
             */
            public static final String ROUTE_5_NETWORK = "route_5_network";
            /**
             * 5th route concurrency ref.
             */
            public static final String ROUTE_5_REF = "route_5_ref";
            /**
             * 5th route concurrency name.
             */
            public static final String ROUTE_5_NAME = "route_5_name";
            /**
             * 5th route concurrency colour.
             */
            public static final String ROUTE_5_COLOUR = "route_5_colour";
            /**
             * 6th route concurrency network.
             */
            public static final String ROUTE_6_NETWORK = "route_6_network";
            /**
             * 6th route concurrency ref.
             */
            public static final String ROUTE_6_REF = "route_6_ref";
            /**
             * 6th route concurrency name.
             */
            public static final String ROUTE_6_NAME = "route_6_name";
            /**
             * 6th route concurrency colour.
             */
            public static final String ROUTE_6_COLOUR = "route_6_colour";
        }

        /**
         * Attribute values for map elements in the transportation_name layer.
         */
        final class FieldValues {
            public static final String NETWORK_US_INTERSTATE = "us-interstate";
            public static final String NETWORK_US_HIGHWAY = "us-highway";
            public static final String NETWORK_US_STATE = "us-state";
            public static final String NETWORK_CA_TRANSCANADA = "ca-transcanada";
            public static final String NETWORK_CA_PROVINCIAL_ARTERIAL = "ca-provincial-arterial";
            public static final String NETWORK_CA_PROVINCIAL = "ca-provincial";
            public static final String NETWORK_GB_MOTORWAY = "gb-motorway";
            public static final String NETWORK_GB_TRUNK = "gb-trunk";
            public static final String NETWORK_GB_PRIMARY = "gb-primary";
            public static final String NETWORK_IE_MOTORWAY = "ie-motorway";
            public static final String NETWORK_IE_NATIONAL = "ie-national";
            public static final String NETWORK_IE_REGIONAL = "ie-regional";
            public static final String NETWORK_ROAD = "road";
            public static final Set<String> NETWORK_VALUES =
                    Set.of("us-interstate", "us-highway", "us-state", "ca-transcanada", "ca-provincial-arterial", "ca-provincial",
                            "gb-motorway", "gb-trunk", "gb-primary", "ie-motorway", "ie-national", "ie-regional", "road");
            public static final String CLASS_MOTORWAY = "motorway";
            public static final String CLASS_TRUNK = "trunk";
            public static final String CLASS_PRIMARY = "primary";
            public static final String CLASS_SECONDARY = "secondary";
            public static final String CLASS_TERTIARY = "tertiary";
            public static final String CLASS_MINOR = "minor";
            public static final String CLASS_SERVICE = "service";
            public static final String CLASS_TRACK = "track";
            public static final String CLASS_PATH = "path";
            public static final String CLASS_RACEWAY = "raceway";
            public static final String CLASS_MOTORWAY_CONSTRUCTION = "motorway_construction";
            public static final String CLASS_TRUNK_CONSTRUCTION = "trunk_construction";
            public static final String CLASS_PRIMARY_CONSTRUCTION = "primary_construction";
            public static final String CLASS_SECONDARY_CONSTRUCTION = "secondary_construction";
            public static final String CLASS_TERTIARY_CONSTRUCTION = "tertiary_construction";
            public static final String CLASS_MINOR_CONSTRUCTION = "minor_construction";
            public static final String CLASS_SERVICE_CONSTRUCTION = "service_construction";
            public static final String CLASS_TRACK_CONSTRUCTION = "track_construction";
            public static final String CLASS_PATH_CONSTRUCTION = "path_construction";
            public static final String CLASS_RACEWAY_CONSTRUCTION = "raceway_construction";
            public static final String CLASS_RAIL = "rail";
            public static final String CLASS_TRANSIT = "transit";
            public static final String CLASS_MOTORWAY_JUNCTION = "motorway_junction";
            public static final Set<String> CLASS_VALUES =
                    Set.of("motorway", "trunk", "primary", "secondary", "tertiary", "minor", "service", "track", "path", "raceway",
                            "motorway_construction", "trunk_construction", "primary_construction", "secondary_construction",
                            "tertiary_construction", "minor_construction", "service_construction", "track_construction",
                            "path_construction", "raceway_construction", "rail", "transit", "motorway_junction");
            public static final String SUBCLASS_PEDESTRIAN = "pedestrian";
            public static final String SUBCLASS_PATH = "path";
            public static final String SUBCLASS_FOOTWAY = "footway";
            public static final String SUBCLASS_CYCLEWAY = "cycleway";
            public static final String SUBCLASS_STEPS = "steps";
            public static final String SUBCLASS_BRIDLEWAY = "bridleway";
            public static final String SUBCLASS_CORRIDOR = "corridor";
            public static final String SUBCLASS_PLATFORM = "platform";
            public static final String SUBCLASS_JUNCTION = "junction";
            public static final Set<String> SUBCLASS_VALUES =
                    Set.of("pedestrian", "path", "footway", "cycleway", "steps", "bridleway", "corridor", "platform", "junction");
            public static final String BRUNNEL_BRIDGE = "bridge";
            public static final String BRUNNEL_TUNNEL = "tunnel";
            public static final String BRUNNEL_FORD = "ford";
            public static final Set<String> BRUNNEL_VALUES = Set.of("bridge", "tunnel", "ford");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the transportation_name layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * The place layer consists out of <a href="http://wiki.openstreetmap.org/wiki/Tag:place%3Dcountry">countries</a>,
     * <a href="http://wiki.openstreetmap.org/wiki/Tag:place%3Dstate">states</a>,
     * <a href="http://wiki.openstreetmap.org/wiki/Key:place">cities</a> and
     * <a href="https://wiki.openstreetmap.org/wiki/Tag:place%3Disland">islands</a>. Apart from the roads this is also one
     * of the more important layers to create a beautiful map. We suggest you use different font styles and sizes to
     * create a text hierarchy.
     * <p>
     * Generated from
     * <a href="https://github.com/openmaptiles/openmaptiles/blob/master/layers/place/place.yaml">place.yaml</a>
     */
    public interface Place extends Layer {
        double BUFFER_SIZE = 256.0;
        String LAYER_NAME = "place";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the place layer.
         */
        final class Fields {
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:name"><code>name</code></a> value of the place.
             * Language-specific values are in <code>name:xx</code>.
             */
            public static final String NAME = "name";
            /**
             * English name <code>name:en</code> if available, otherwise <code>name</code>. This is deprecated and will be
             * removed in a future release in favor of <code>name:en</code>.
             */
            public static final String NAME_EN = "name_en";
            /**
             * German name <code>name:de</code> if available, otherwise <code>name</code> or <code>name:en</code>. This is
             * deprecated and will be removed in a future release in favor of <code>name:de</code>.
             */
            public static final String NAME_DE = "name_de";

            /**
             * The <strong>capital</strong> field marks the <a href=
             * "http://wiki.openstreetmap.org/wiki/Tag:boundary%3Dadministrative#admin_level"><code>admin_level</code></a> of
             * the boundary the place is a capital of.
             * <p>
             * allowed values:
             * <ul>
             * <li>2
             * <li>3
             * <li>4
             * <li>5
             * <li>6
             * </ul>
             */
            public static final String CAPITAL = "capital";

            /**
             * Original value of the <a href="http://wiki.openstreetmap.org/wiki/Key:place"><code>place</code></a> tag.
             * Distinguish between continents, countries, states, islands and places like settlements or smaller entities. Use
             * <strong>class</strong> to separately style the different places and build a text hierarchy according to their
             * importance. For places derived from boundaries, the original value of the
             * <a href="http://wiki.openstreetmap.org/wiki/Key:boundary"><code>boundary</code></a> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>"continent"
             * <li>"country"
             * <li>"state"
             * <li>"province"
             * <li>"city"
             * <li>"town"
             * <li>"village"
             * <li>"hamlet"
             * <li>"borough"
             * <li>"suburb"
             * <li>"quarter"
             * <li>"neighbourhood"
             * <li>"isolated_dwelling"
             * <li>"island"
             * <li>"aboriginal_lands"
             * </ul>
             */
            public static final String CLASS = "class";
            /**
             * Two-letter country code <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>.
             * Available only for <code>class=country</code>. Original value of the <a href=
             * "http://wiki.openstreetmap.org/wiki/Tag:place%3Dcountry"><code>country_code_iso3166_1_alpha_2</code></a> tag.
             */
            public static final String ISO_A2 = "iso_a2";
            /**
             * Countries, states and the most important cities all have a <strong>rank</strong> to boost their importance on
             * the map. The <strong>rank</strong> field for countries and states ranges from <code>1</code> to <code>6</code>
             * while the <strong>rank</strong> field for cities ranges from <code>1</code> to <code>10</code> for the most
             * important cities and continues from <code>10</code> serially based on the local importance of the city (derived
             * from population and city class). You can use the <strong>rank</strong> to limit density of labels or improve
             * the text hierarchy. The rank value is a combination of the Natural Earth <code>scalerank</code>,
             * <code>labelrank</code> and <code>datarank</code> values for countries and states and for cities consists out of
             * a shifted Natural Earth <code>scalerank</code> combined with a local rank within a grid for cities that do not
             * have a Natural Earth <code>scalerank</code>.
             */
            public static final String RANK = "rank";
        }

        /**
         * Attribute values for map elements in the place layer.
         */
        final class FieldValues {
            public static final String CLASS_CONTINENT = "continent";
            public static final String CLASS_COUNTRY = "country";
            public static final String CLASS_STATE = "state";
            public static final String CLASS_PROVINCE = "province";
            public static final String CLASS_CITY = "city";
            public static final String CLASS_TOWN = "town";
            public static final String CLASS_VILLAGE = "village";
            public static final String CLASS_HAMLET = "hamlet";
            public static final String CLASS_BOROUGH = "borough";
            public static final String CLASS_SUBURB = "suburb";
            public static final String CLASS_QUARTER = "quarter";
            public static final String CLASS_NEIGHBOURHOOD = "neighbourhood";
            public static final String CLASS_ISOLATED_DWELLING = "isolated_dwelling";
            public static final String CLASS_ISLAND = "island";
            public static final String CLASS_ABORIGINAL_LANDS = "aboriginal_lands";
            public static final Set<String> CLASS_VALUES =
                    Set.of("continent", "country", "state", "province", "city", "town", "village", "hamlet", "borough", "suburb",
                            "quarter", "neighbourhood", "isolated_dwelling", "island", "aboriginal_lands");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the place layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * Everything in OpenStreetMap which contains a <code>addr:housenumber</code> tag useful for labelling housenumbers on
     * a map. This adds significant size to <em>z14</em>. For buildings the centroid of the building is used as
     * housenumber. Duplicates within a tile are dropped if they have the same street/block_number (records without name
     * tag are prioritized for preservation).
     * <p>
     * Generated from <a href=
     * "https://github.com/openmaptiles/openmaptiles/blob/master/layers/housenumber/housenumber.yaml">housenumber.yaml</a>
     */
    public interface Housenumber extends Layer {
        double BUFFER_SIZE = 8.0;
        String LAYER_NAME = "housenumber";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the housenumber layer.
         */
        final class Fields {
            /**
             * Value of the <a href="http://wiki.openstreetmap.org/wiki/Key:addr"><code>addr:housenumber</code></a> tag. If
             * there are multiple values separated by semi-colons, the first and last value separated by a dash.
             */
            public static final String HOUSENUMBER = "housenumber";
        }

        /**
         * Attribute values for map elements in the housenumber layer.
         */
        final class FieldValues {

        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the housenumber layer.
         */
        final class FieldMappings {

        }
    }

    /**
     * <a href="http://wiki.openstreetmap.org/wiki/Points_of_interest">Points of interests</a> containing a of a variety
     * of OpenStreetMap tags. Mostly contains amenities, sport, shop and tourist POIs.
     * <p>
     * Generated from <a href="https://github.com/openmaptiles/openmaptiles/blob/master/layers/poi/poi.yaml">poi.yaml</a>
     */
    public interface Poi extends Layer {
        double BUFFER_SIZE = 64.0;
        String LAYER_NAME = "poi";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the poi layer.
         */
        final class Fields {
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:name"><code>name</code></a> value of the POI.
             * Language-specific values are in <code>name:xx</code>.
             */
            public static final String NAME = "name";
            /**
             * English name <code>name:en</code> if available, otherwise <code>name</code>. This is deprecated and will be
             * removed in a future release in favor of <code>name:en</code>.
             */
            public static final String NAME_EN = "name_en";
            /**
             * German name <code>name:de</code> if available, otherwise <code>name</code> or <code>name:en</code>. This is
             * deprecated and will be removed in a future release in favor of <code>name:de</code>.
             */
            public static final String NAME_DE = "name_de";

            /**
             * More general classes of POIs. If there is no more general <code>class</code> for the <code>subclass</code> this
             * field will contain the same value as <code>subclass</code>. But for example for schools you only need to style
             * the class <code>school</code> to filter the subclasses <code>school</code> and <code>kindergarten</code>. Or
             * use the class <code>shop</code> to style all shops.
             * <p>
             * allowed values:
             * <ul>
             * <li>shop
             * <li>office
             * <li>town_hall
             * <li>golf
             * <li>fast_food
             * <li>park
             * <li>bus
             * <li>railway
             * <li>aerialway
             * <li>entrance
             * <li>campsite
             * <li>laundry
             * <li>grocery
             * <li>library
             * <li>college
             * <li>lodging
             * <li>ice_cream
             * <li>post
             * <li>cafe
             * <li>school
             * <li>alcohol_shop
             * <li>bar
             * <li>harbor
             * <li>car
             * <li>hospital
             * <li>cemetery
             * <li>attraction
             * <li>beer
             * <li>music
             * <li>stadium
             * <li>art_gallery
             * <li>clothing_store
             * <li>swimming
             * <li>castle
             * <li>atm
             * <li>fuel
             * </ul>
             */
            public static final String CLASS = "class";
            /**
             * Original value of either the <a href="http://wiki.openstreetmap.org/wiki/Key:amenity"><code>amenity</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:barrier"><code>barrier</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:historic"><code>historic</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:information"><code>information</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:landuse"><code>landuse</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:leisure"><code>leisure</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:railway"><code>railway</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:shop"><code>shop</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:sport"><code>sport</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:station"><code>station</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:religion"><code>religion</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:tourism"><code>tourism</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:aerialway"><code>aerialway</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:building"><code>building</code></a>,
             * <a href="http://wiki.openstreetmap.org/wiki/Key:highway"><code>highway</code></a>,
             * <a href="https://wiki.openstreetmap.org/wiki/Key:office"><code>office</code></a> or
             * <a href="http://wiki.openstreetmap.org/wiki/Key:waterway"><code>waterway</code></a> tag. Use this to do more
             * precise styling.
             */
            public static final String SUBCLASS = "subclass";
            /**
             * The POIs are ranked ascending according to their importance within a grid. The <code>rank</code> value shows
             * the local relative importance of a POI within it's cell in the grid. This can be used to reduce label density
             * at <em>z14</em>. Since all POIs already need to be contained at <em>z14</em> you can use
             * <code>less than rank=10</code> epxression to limit POIs. At some point like <em>z17</em> you can show all POIs.
             */
            public static final String RANK = "rank";

            /**
             * Experimental feature! Indicates main platform of public transport stops (buses, trams, and subways). Grouping
             * of platforms is implemented using
             * <a href="http://wiki.openstreetmap.org/wiki/Key:uic_ref"><code>uic_ref</code></a> tag that is not used
             * worldwide.
             * <p>
             * allowed values:
             * <ul>
             * <li>1
             * </ul>
             */
            public static final String AGG_STOP = "agg_stop";
            /**
             * Original value of <a href="http://wiki.openstreetmap.org/wiki/Key:level"><code>level</code></a> tag.
             */
            public static final String LEVEL = "level";
            /**
             * Original value of <a href="http://wiki.openstreetmap.org/wiki/Key:layer"><code>layer</code></a> tag.
             */
            public static final String LAYER = "layer";

            /**
             * Original value of <a href="http://wiki.openstreetmap.org/wiki/Key:indoor"><code>indoor</code></a> tag.
             * <p>
             * allowed values:
             * <ul>
             * <li>1
             * </ul>
             */
            public static final String INDOOR = "indoor";
        }

        /**
         * Attribute values for map elements in the poi layer.
         */
        final class FieldValues {
            public static final String CLASS_SHOP = "shop";
            public static final String CLASS_OFFICE = "office";
            public static final String CLASS_TOWN_HALL = "town_hall";
            public static final String CLASS_GOLF = "golf";
            public static final String CLASS_FAST_FOOD = "fast_food";
            public static final String CLASS_PARK = "park";
            public static final String CLASS_BUS = "bus";
            public static final String CLASS_RAILWAY = "railway";
            public static final String CLASS_AERIALWAY = "aerialway";
            public static final String CLASS_ENTRANCE = "entrance";
            public static final String CLASS_CAMPSITE = "campsite";
            public static final String CLASS_LAUNDRY = "laundry";
            public static final String CLASS_GROCERY = "grocery";
            public static final String CLASS_LIBRARY = "library";
            public static final String CLASS_COLLEGE = "college";
            public static final String CLASS_LODGING = "lodging";
            public static final String CLASS_ICE_CREAM = "ice_cream";
            public static final String CLASS_POST = "post";
            public static final String CLASS_CAFE = "cafe";
            public static final String CLASS_SCHOOL = "school";
            public static final String CLASS_ALCOHOL_SHOP = "alcohol_shop";
            public static final String CLASS_BAR = "bar";
            public static final String CLASS_HARBOR = "harbor";
            public static final String CLASS_CAR = "car";
            public static final String CLASS_HOSPITAL = "hospital";
            public static final String CLASS_CEMETERY = "cemetery";
            public static final String CLASS_ATTRACTION = "attraction";
            public static final String CLASS_BEER = "beer";
            public static final String CLASS_MUSIC = "music";
            public static final String CLASS_STADIUM = "stadium";
            public static final String CLASS_ART_GALLERY = "art_gallery";
            public static final String CLASS_CLOTHING_STORE = "clothing_store";
            public static final String CLASS_SWIMMING = "swimming";
            public static final String CLASS_CASTLE = "castle";
            public static final String CLASS_ATM = "atm";
            public static final String CLASS_FUEL = "fuel";
            public static final Set<String> CLASS_VALUES = Set.of("shop", "office", "town_hall", "golf", "fast_food", "park",
                    "bus", "railway", "aerialway", "entrance", "campsite", "laundry", "grocery", "library", "college", "lodging",
                    "ice_cream", "post", "cafe", "school", "alcohol_shop", "bar", "harbor", "car", "hospital", "cemetery",
                    "attraction", "beer", "music", "stadium", "art_gallery", "clothing_store", "swimming", "castle", "atm", "fuel");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the poi layer.
         */
        final class FieldMappings {
            public static final MultiExpression<String> Class = MultiExpression.of(List.of(
                    MultiExpression.entry("shop",
                            matchAny("subclass", "accessories", "antiques", "beauty", "bed", "boutique", "camera", "carpet", "charity",
                                    "chemist", "chocolate", "coffee", "computer", "convenience", "confectionery", "copyshop", "cosmetics",
                                    "garden_centre", "doityourself", "erotic", "electronics", "fabric", "florist", "frozen_food", "furniture",
                                    "video_games", "video", "general", "gift", "hardware", "hearing_aids", "hifi", "interior_decoration",
                                    "jewelry", "kiosk", "locksmith", "lamps", "mall", "massage", "motorcycle", "mobile_phone", "newsagent",
                                    "optician", "outdoor", "paint", "perfumery", "perfume", "pet", "photo", "second_hand", "shoes", "sports",
                                    "stationery", "tailor", "tattoo", "ticket", "tobacco", "toys", "travel_agency", "watches", "weapons",
                                    "wholesale")),
                    MultiExpression.entry("office",
                            matchAny("subclass", "accountant", "advertising_agency", "architect", "association", "bail_bond_agent",
                                    "charity", "company", "construction_company", "consulting", "cooperative", "courier", "coworking",
                                    "diplomatic", "educational_institution", "employment_agency", "energy_supplier", "engineer", "estate_agent",
                                    "financial", "financial_advisor", "forestry", "foundation", "geodesist", "government", "graphic_design",
                                    "guide", "harbour_master", "health_insurance", "insurance", "interior_design", "it", "lawyer", "logistics",
                                    "marketing", "moving_company", "newspaper", "ngo", "notary", "physician", "political_party",
                                    "private_investigator", "property_management", "publisher", "quango", "religion", "research", "security",
                                    "surveyor", "tax_advisor", "taxi", "telecommunication", "therapist", "translator", "travel_agent",
                                    "tutoring", "union", "university", "water_utility", "web_design", "wedding_planner")),
                    MultiExpression.entry("town_hall",
                            matchAny("subclass", "townhall", "public_building", "courthouse", "community_centre")),
                    MultiExpression.entry("golf", matchAny("subclass", "golf", "golf_course", "miniature_golf")),
                    MultiExpression.entry("fast_food", matchAny("subclass", "fast_food", "food_court")),
                    MultiExpression.entry("park", matchAny("subclass", "park", "bbq")),
                    MultiExpression.entry("bus", matchAny("subclass", "bus_stop", "bus_station")),
                    MultiExpression.entry("railway",
                            or(and(matchAny("subclass", "station"), matchAny("mapping_key", "railway")),
                                    matchAny("subclass", "halt", "tram_stop", "subway"))),
                    MultiExpression.entry("aerialway", and(matchAny("subclass", "station"), matchAny("mapping_key", "aerialway"))),
                    MultiExpression.entry("entrance", matchAny("subclass", "subway_entrance", "train_station_entrance")),
                    MultiExpression.entry("campsite", matchAny("subclass", "camp_site", "caravan_site")),
                    MultiExpression.entry("laundry", matchAny("subclass", "laundry", "dry_cleaning")),
                    MultiExpression.entry("grocery",
                            matchAny("subclass", "supermarket", "deli", "delicatessen", "department_store", "greengrocer",
                                    "marketplace")),
                    MultiExpression.entry("library", matchAny("subclass", "books", "library")),
                    MultiExpression.entry("college", matchAny("subclass", "university", "college")),
                    MultiExpression.entry("lodging",
                            matchAny("subclass", "hotel", "motel", "bed_and_breakfast", "guest_house", "hostel", "chalet", "alpine_hut",
                                    "dormitory")),
                    MultiExpression.entry("ice_cream", matchAny("subclass", "ice_cream")),
                    MultiExpression.entry("post", matchAny("subclass", "post_box", "post_office", "parcel_locker")),
                    MultiExpression.entry("cafe", matchAny("subclass", "cafe")),
                    MultiExpression.entry("school", matchAny("subclass", "school", "kindergarten")),
                    MultiExpression.entry("alcohol_shop", matchAny("subclass", "alcohol", "beverages", "wine")),
                    MultiExpression.entry("bar", matchAny("subclass", "bar", "nightclub")),
                    MultiExpression.entry("harbor", matchAny("subclass", "marina", "dock")),
                    MultiExpression.entry("car", matchAny("subclass", "car", "car_repair", "car_parts", "taxi")),
                    MultiExpression.entry("hospital", matchAny("subclass", "hospital", "nursing_home", "clinic")),
                    MultiExpression.entry("cemetery", matchAny("subclass", "grave_yard", "cemetery")),
                    MultiExpression.entry("attraction", matchAny("subclass", "attraction", "viewpoint")),
                    MultiExpression.entry("beer", matchAny("subclass", "biergarten", "pub")),
                    MultiExpression.entry("music", matchAny("subclass", "music", "musical_instrument")),
                    MultiExpression.entry("stadium", matchAny("subclass", "american_football", "stadium", "soccer")),
                    MultiExpression.entry("art_gallery", matchAny("subclass", "art", "artwork", "gallery", "arts_centre")),
                    MultiExpression.entry("clothing_store", matchAny("subclass", "bag", "clothes")),
                    MultiExpression.entry("swimming", matchAny("subclass", "swimming_area", "swimming")),
                    MultiExpression.entry("castle", matchAny("subclass", "castle", "ruins")),
                    MultiExpression.entry("atm", matchAny("subclass", "atm")),
                    MultiExpression.entry("fuel", matchAny("subclass", "fuel", "charging_station"))));
        }
    }

    /**
     * <a href="http://wiki.openstreetmap.org/wiki/Tag:aeroway%3Daerodrome">Aerodrome labels</a>
     * <p>
     * Generated from <a href=
     * "https://github.com/openmaptiles/openmaptiles/blob/master/layers/aerodrome_label/aerodrome_label.yaml">aerodrome_label.yaml</a>
     */
    public interface AerodromeLabel extends Layer {
        double BUFFER_SIZE = 64.0;
        String LAYER_NAME = "aerodrome_label";

        @Override
        default String name() {
            return LAYER_NAME;
        }

        /**
         * Attribute names for map elements in the aerodrome_label layer.
         */
        final class Fields {
            /**
             * The OSM <a href="http://wiki.openstreetmap.org/wiki/Key:name"><code>name</code></a> value of the aerodrome.
             * Language-specific values are in <code>name:xx</code>.
             */
            public static final String NAME = "name";
            /**
             * English name <code>name:en</code> if available, otherwise <code>name</code>. This is deprecated and will be
             * removed in a future release in favor of <code>name:en</code>.
             */
            public static final String NAME_EN = "name_en";
            /**
             * German name <code>name:de</code> if available, otherwise <code>name</code> or <code>name:en</code>. This is
             * deprecated and will be removed in a future release in favor of <code>name:de</code>.
             */
            public static final String NAME_DE = "name_de";

            /**
             * Distinguish between more and less important aerodromes. Class is derived from the value of
             * <a href="http://wiki.openstreetmap.org/wiki/Proposed_features/Aerodrome"><code>aerodrome</code></a> and
             * <code>aerodrome:type</code> tags.
             * <p>
             * allowed values:
             * <ul>
             * <li>international
             * <li>public
             * <li>regional
             * <li>military
             * <li>private
             * <li>other
             * </ul>
             */
            public static final String CLASS = "class";
            /**
             * 3-character code issued by the IATA.
             */
            public static final String IATA = "iata";
            /**
             * 4-letter code issued by the ICAO.
             */
            public static final String ICAO = "icao";
            /**
             * Elevation (<code>ele</code>) in meters.
             */
            public static final String ELE = "ele";
            /**
             * Elevation (<code>ele</code>) in feets.
             */
            public static final String ELE_FT = "ele_ft";
        }

        /**
         * Attribute values for map elements in the aerodrome_label layer.
         */
        final class FieldValues {
            public static final String CLASS_INTERNATIONAL = "international";
            public static final String CLASS_PUBLIC = "public";
            public static final String CLASS_REGIONAL = "regional";
            public static final String CLASS_MILITARY = "military";
            public static final String CLASS_PRIVATE = "private";
            public static final String CLASS_OTHER = "other";
            public static final Set<String> CLASS_VALUES =
                    Set.of("international", "public", "regional", "military", "private", "other");
        }

        /**
         * Complex mappings to generate attribute values from OSM element tags in the aerodrome_label layer.
         */
        final class FieldMappings {
            public static final MultiExpression<String> Class = MultiExpression.of(List.of(
                    MultiExpression.entry("international",
                            or(matchAny("aerodrome", "international"), matchAny("aerodrome_type", "international"))),
                    MultiExpression.entry("public",
                            or(matchAny("aerodrome", "public"), matchAny("aerodrome_type", "%public%", "civil"))),
                    MultiExpression.entry("regional",
                            or(matchAny("aerodrome", "regional"), matchAny("aerodrome_type", "regional"))),
                    MultiExpression.entry("military",
                            or(matchAny("aerodrome", "military"), matchAny("aerodrome_type", "%military%"),
                                    matchAny("military", "airfield"))),
                    MultiExpression.entry("private", or(matchAny("aerodrome", "private"), matchAny("aerodrome_type", "private"))),
                    MultiExpression.entry("other", FALSE)));
        }
    }
}