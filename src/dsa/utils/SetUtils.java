package algo.utils;

import java.util.*;

public class SetUtils {

    public static <T> Set<T> diff(Set<T> set1, Set<T> set2) {
        Set<T> diff = new HashSet<>();
        for(T item: set1) {
            if(!set2.contains(item)) diff.add(item);
        }

        for(T item: set2) {
            if(!set1.contains(item)) diff.add(item);
        }
        return diff;
    }

    public static <T> List<T> findDuplicates(List<T> items) {
        Set<T> set = new HashSet<>();
        List<T> duplicates = new ArrayList<>();
        for(T item: items) {
            if(set.contains(item)) {
                duplicates.add(item);
            } else {
                set.add(item);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        List<String> set1 = new ArrayList<>(Arrays.asList("xnova,1,1253,madrid","chalicefy,7,1593,munich","xnova,10,368,warsaw","chalicefy,18,1059,zurich","xnova,31,338,barcelona","iris,43,71,taipei","iris,48,541,milan","iris,50,566,guangzhou","iris,59,963,beijing","iris,64,508,budapest","maybe,53,532,shanghai","maybe,71,1498,zurich","alex,77,986,luxembourg","alex,83,721,bangkok","alex,84,702,toronto","alex,85,21,tokyo","iris,88,247,mexico","maybe,89,473,shanghai","iris,99,1987,amsterdam","chalicefy,102,1562,warsaw","maybe,110,383,montreal","lee,76,279,warsaw","lee,112,1809,bangkok","lee,118,446,shenzhen","bob,121,1984,zurich","bob,121,491,chicago","iris,126,101,madrid","chalicefy,129,1875,guangzhou","lee,137,852,taipei","bob,140,775,munich","iris,172,1241,dubai","lee,139,939,taipei","lee,173,655,milan","xnova,173,1166,barcelona","bob,173,242,dubai","chalicefy,174,292,mexico","bob,175,629,singapore","xnova,180,159,milan","bob,190,1608,dubai","bob,199,284,hongkong","bob,211,1104,munich","lee,217,1756,shenzhen","bob,218,985,dubai","chalicefy,228,1075,hongkong","bob,236,930,prague","lee,247,526,luxembourg","chalicefy,257,1683,paris","xnova,248,775,moscow","xnova,260,618,montreal","lee,265,217,amsterdam","xnova,267,1636,frankfurt","xnova,272,838,amsterdam","lee,275,67,guangzhou","bob,279,339,luxembourg","maybe,284,1300,moscow","iris,239,98,tokyo","iris,290,929,zurich","lee,305,1825,moscow","xnova,308,73,frankfurt","maybe,312,958,mexico","iris,313,672,munich","lee,319,864,warsaw","bob,323,325,warsaw","alex,306,42,hongkong","alex,325,798,moscow","alex,334,1792,hongkong","iris,340,716,hongkong","alex,342,102,jakarta","xnova,344,510,shenzhen","bob,348,1280,hongkong","lee,354,466,toronto","xnova,356,274,taipei","alex,356,1879,rome","iris,358,914,newdelhi","bob,362,653,luxembourg","chalicefy,372,1590,taipei","maybe,373,1335,warsaw","iris,377,1834,barcelona","iris,378,487,budapest","alex,386,229,shenzhen","bob,386,574,hongkong","lee,390,116,warsaw","xnova,390,1518,budapest","bob,399,392,jakarta","maybe,408,842,barcelona","alex,408,314,mexico","lee,414,1954,moscow","bob,418,661,dubai","iris,420,330,frankfurt","xnova,424,1674,moscow","iris,425,228,moscow","iris,429,200,mexico","alex,448,1029,prague","lee,452,740,montreal","chalicefy,454,1295,taipei","chalicefy,456,530,beijing","chalicefy,458,708,montreal","alex,462,1069,toronto","lee,470,596,rome","xnova,477,761,newdelhi","lee,498,806,hongkong","maybe,495,175,istanbul","maybe,498,1993,chicago","maybe,500,844,milan","lee,500,519,mexico","alex,501,1623,tokyo","xnova,503,891,chicago","alex,508,559,prague","lee,519,1629,madrid","xnova,519,22,bangkok","alex,526,966,milan","alex,531,1032,shenzhen","maybe,542,393,warsaw","maybe,543,0,prague","maybe,545,496,montreal","maybe,546,829,zurich","xnova,547,1305,bangkok","iris,543,711,toronto","iris,562,78,madrid","alex,567,924,madrid","maybe,571,1312,bangkok","bob,574,1493,barcelona","xnova,584,433,shenzhen","bob,612,628,amsterdam","bob,616,191,milan","maybe,628,378,prague","bob,637,532,beijing","chalicefy,633,51,singapore","chalicefy,639,512,paris","iris,640,1611,budapest","chalicefy,657,998,zurich","bob,658,69,madrid","alex,659,1525,moscow","xnova,668,1807,chicago","bob,674,440,jakarta","iris,691,1961,milan","alex,698,789,singapore","xnova,701,878,newdelhi","alex,711,1745,dubai","alex,713,813,toronto","alex,740,634,taipei","iris,743,234,warsaw","alex,746,1760,rome","lee,762,87,chicago","lee,764,583,bangkok","iris,766,1413,rome","alex,766,1218,madrid","lee,771,543,guangzhou","maybe,771,153,milan","maybe,772,783,munich","bob,768,976,zurich","bob,785,203,beijing","lee,790,574,barcelona","bob,802,1881,paris","maybe,808,4,taipei","bob,824,294,bangkok","bob,859,347,jakarta","maybe,862,1798,warsaw","xnova,812,270,barcelona","xnova,863,459,taipei","bob,870,3,madrid","bob,887,731,jakarta","alex,887,1782,rome","lee,872,8,tokyo","lee,889,927,zurich","maybe,906,1091,beijing","alex,910,1325,moscow","lee,912,710,bangkok","chalicefy,897,562,jakarta","chalicefy,919,548,hongkong","chalicefy,921,378,chicago","maybe,921,10,montreal","maybe,930,688,luxembourg","alex,935,697,munich","chalicefy,935,606,beijing","lee,942,1683,rome","chalicefy,953,683,moscow","iris,956,1795,taipei","lee,967,1176,milan","lee,968,699,istanbul","iris,971,1828,frankfurt","iris,972,940,toronto","chalicefy,965,600,moscow","chalicefy,993,508,prague","lee,993,963,mexico","iris,993,82,madrid","iris,999,415,newdelhi","iris,1000,1965,munich"));
        List<String> set2 = new ArrayList<>(Arrays.asList("bob,121,1984,zurich","maybe,53,532,shanghai","alex,83,721,bangkok","maybe,906,1091,beijing","iris,691,1961,milan","xnova,272,838,amsterdam","alex,462,1069,toronto","chalicefy,456,530,beijing","chalicefy,699,617,zurich","lee,247,526,luxembourg","xnova,31,338,barcelona","bob,348,1280,hongkong","maybe,542,393,warsaw","bob,362,653,luxembourg","iris,290,929,zurich","bob,887,731,jakarta","xnova,863,459,taipei","xnova,180,159,milan","iris,43,71,taipei","lee,872,8,tokyo","bob,218,985,dubai","chalicefy,993,508,prague","alex,386,229,shenzhen","alex,567,924,madrid","maybe,408,842,barcelona","xnova,503,891,chicago","chalicefy,921,378,chicago","alex,935,697,munich","lee,305,1825,moscow","iris,429,200,mexico","alex,325,798,moscow","alex,698,789,singapore","maybe,628,378,prague","xnova,424,1674,moscow","bob,859,347,jakarta","lee,498,806,hongkong","alex,740,634,taipei","maybe,862,1798,warsaw","chalicefy,102,1562,warsaw","maybe,284,1300,moscow","iris,172,1241,dubai","lee,519,1629,madrid","iris,971,1828,frankfurt","lee,470,596,rome","alex,746,1760,rome","iris,420,330,frankfurt","lee,967,1176,milan","lee,354,466,toronto","chalicefy,372,1590,taipei","xnova,584,433,shenzhen","bob,121,491,chicago","chalicefy,965,600,moscow","alex,77,986,luxembourg","lee,319,864,warsaw","bob,574,1493,barcelona","xnova,308,73,frankfurt","lee,112,1809,bangkok","chalicefy,174,292,mexico","lee,764,583,bangkok","bob,612,628,amsterdam","maybe,930,688,luxembourg","bob,768,976,zurich","alex,526,966,milan","iris,378,487,budapest","alex,501,1623,tokyo","alex,508,559,prague","lee,173,655,milan","bob,658,69,madrid","bob,279,339,luxembourg","iris,640,1611,budapest","lee,275,67,guangzhou","xnova,10,368,warsaw","bob,386,574,hongkong","iris,766,1413,rome","iris,59,963,beijing","maybe,500,844,milan","chalicefy,18,1059,zurich","maybe,89,473,shanghai","lee,790,574,barcelona","alex,84,702,toronto","xnova,519,22,bangkok","xnova,701,878,newdelhi","alex,85,21,tokyo","lee,912,710,bangkok","maybe,312,958,mexico","maybe,495,175,istanbul","chalicefy,129,1875,guangzhou","iris,64,508,budapest","bob,870,3,madrid","lee,265,217,amsterdam","alex,306,42,hongkong","lee,889,927,zurich","maybe,771,153,milan","iris,340,716,hongkong","xnova,248,775,moscow","alex,887,1782,rome","xnova,356,274,taipei","bob,637,532,beijing","iris,239,98,tokyo","bob,199,284,hongkong","lee,452,740,montreal","lee,500,519,mexico","lee,942,1683,rome","bob,802,1881,paris","bob,824,294,bangkok","maybe,498,1993,chicago","lee,968,699,istanbul","alex,408,314,mexico","lee,762,87,chicago","iris,50,566,guangzhou","alex,713,813,toronto","maybe,808,4,taipei","iris,313,672,munich","alex,711,1745,dubai","bob,211,1104,munich","lee,217,1756,shenzhen","bob,785,203,beijing","maybe,921,10,montreal","iris,543,711,toronto","maybe,543,0,prague","chalicefy,919,548,hongkong","alex,910,1325,moscow","alex,659,1525,moscow","alex,342,102,jakarta","xnova,477,761,newdelhi","bob,175,629,singapore","chalicefy,458,708,montreal","chalicefy,7,1593,munich","iris,743,234,warsaw","maybe,545,496,montreal","alex,531,1032,shenzhen","lee,137,852,taipei","lee,993,963,mexico","bob,418,661,dubai","xnova,344,510,shenzhen","maybe,71,1498,zurich","maybe,546,829,zurich","lee,390,116,warsaw","bob,190,1608,dubai","maybe,373,1335,warsaw","iris,1000,1965,munich","maybe,772,783,munich","iris,993,82,madrid","bob,236,930,prague","alex,334,1792,hongkong","chalicefy,633,51,singapore","lee,139,939,taipei","alex,356,1879,rome","xnova,390,1518,budapest","maybe,110,383,montreal","chalicefy,257,1683,paris","iris,126,101,madrid","xnova,547,1305,bangkok","iris,358,914,newdelhi","lee,771,543,guangzhou","xnova,668,1807,chicago","iris,956,1795,taipei","bob,674,440,jakarta","lee,414,1954,moscow","lee,76,279,warsaw","iris,377,1834,barcelona","xnova,173,1166,barcelona","xnova,1,1253,madrid","bob,173,242,dubai","xnova,260,618,montreal","chalicefy,228,1075,hongkong","alex,448,1029,prague","alex,766,1218,madrid","iris,48,541,milan","chalicefy,657,998,zurich","chalicefy,897,562,jakarta","bob,140,775,munich","chalicefy,953,683,moscow","chalicefy,935,606,beijing","iris,999,415,newdelhi","iris,972,940,toronto","lee,118,446,shenzhen","iris,99,1987,amsterdam","chalicefy,454,1295,taipei","maybe,571,1312,bangkok","bob,616,191,milan","xnova,812,270,barcelona","xnova,267,1636,frankfurt","iris,425,228,moscow","chalicefy,639,512,paris","iris,562,78,madrid","bob,323,325,warsaw","iris,88,247,mexico","bob,399,392,jakarta"));
        System.out.println(diff(new HashSet<>(set1), new HashSet<>(set2)));
        System.out.println(findDuplicates(set1));

    }
}