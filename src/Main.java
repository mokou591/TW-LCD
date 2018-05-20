import java.util.*;

/**
 * 将数字转换为LCD。
 * https://github.com/mokou591/TW-LCD
 * @author mokou591
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String numberString;
        while (input.hasNext()) {
            numberString = input.next();
            System.out.println(Main.buildLCD(numberString));
        }
    }

    private static final int LCD_HEIGHT = 3;

    private static final String LINE_SEPARATER = System.lineSeparator();

    private static final String LCD_SEPARATER = " ";

    private static final String[][] GET_NUMBER_LINE = {
            //0
            {
                    "._.",
                    "|.|",
                    "|_|"
            },
            //1
            {
                    "...",
                    "..|",
                    "..|"
            },
            //2
            {
                    "._.",
                    "._|",
                    "|_."
            },
            //3
            {
                    "._.",
                    "._|",
                    "._|"
            },
            //4
            {
                    "...",
                    "|_|",
                    "..|"
            },
            //5
            {
                    "._.",
                    "|_.",
                    "._|"
            },
            //6
            {
                    "._.",
                    "|_.",
                    "|_|"
            },
            //7
            {
                    "._.",
                    "..|",
                    "..|"
            },
            //8
            {
                    "._.",
                    "|_|",
                    "|_|"
            },
            //9
            {
                    "._.",
                    "|_|",
                    "..|"
            },
    };

    /**
     * 生成表示LCD的字符串。
     * @param numberString 由数字组成的字符串
     * @return 表示LCD的字符串
     */
    public static String buildLCD(String numberString) {
        //储存每位数字
        Collection<Integer> integers = split(numberString);
        //生成各行
        List<String> lineList = new ArrayList<String>(LCD_HEIGHT);
        for (int lineIndex = 0; lineIndex < LCD_HEIGHT; lineIndex++) {
            lineList.add(buildLine(integers, lineIndex));
        }
        //组合各行，以换行符隔开
        return join(lineList, LINE_SEPARATER);
    }

    /**
     * 按位分隔数字字符串，储存成集合。
     */
    private static Collection<Integer> split(String numberString) {
        List<Integer> numberList = new ArrayList<Integer>(numberString.length());
        for (int i = 0; i < numberString.length(); i++) {
            numberList.add(numberString.charAt(i) - '0');
        }
        return numberList;
    }

    /**
     * 生成LCD字符串。
     * @param collection 数字集合
     * @param lineIndex 行下标
     * @return 表示LCD指定行的字符串
     */
    private static String buildLine(Collection<Integer> collection, int lineIndex) {
        List<String> lineStringList = new ArrayList<String>();
        for (Integer digit : collection) {
            lineStringList.add(GET_NUMBER_LINE[digit][lineIndex]);
        }
        return join(lineStringList, LCD_SEPARATER);
    }

    /**
     * 按分隔符连接若干个字符串。
     */
    private static String join(Collection<String> collection, String separator) {
        StringBuilder joinString = new StringBuilder();
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            joinString.append(string);
            //若不是最后一个，则加入分隔符
            if (iterator.hasNext()) {
                joinString.append(separator);
            }
        }
        return joinString.toString();
    }

}
