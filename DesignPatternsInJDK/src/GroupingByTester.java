import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 *
 */
public class GroupingByTester {

    List<Package> packages = new ArrayList<>();

    public static void main(String[] args) {
        //grouping by TYPE
        GroupingByTester groupingByTester = new GroupingByTester();
        groupingByTester.generateData();
        Map<PackageType, List<Package>> packagePerType = groupingByTester.packages.stream()
                .collect(groupingBy(Package::getType));

        for (PackageType key : packagePerType.keySet()) {
            System.out.println(packagePerType.get(key));
        }

    }

    class Package {
        String number;
        String weight;
        PackageType type;

        public Package(String number, String weight, PackageType type) {
            this.number = number;
            this.weight = weight;
            this.type = type;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public PackageType getType() {
            return type;
        }

        public void setType(PackageType type) {
            this.type = type;
        }

        @Override public String toString() {
            final StringBuffer sb = new StringBuffer("Package{");
            sb.append("number='")
                    .append(number)
                    .append('\'');
            sb.append(", weight='")
                    .append(weight)
                    .append('\'');
            sb.append(", type=")
                    .append(type);
            sb.append('}');
            return sb.toString();
        }
    }

    enum PackageType {
        MEDIUM_SIZE,
        AXXXXXXX_S,
        SMALL_SIZE,

    }

    private void generateData() {
        this.packages.add(new Package("321", "50", PackageType.SMALL_SIZE));
        this.packages.add(new Package("122", "11", PackageType.SMALL_SIZE));
        this.packages.add(new Package("333", "25", PackageType.MEDIUM_SIZE));
        this.packages.add(new Package("543", "38", PackageType.SMALL_SIZE));
        this.packages.add(new Package("221", "28", PackageType.MEDIUM_SIZE));
        this.packages.add(new Package("298", "21", PackageType.MEDIUM_SIZE));
        this.packages.add(new Package("8276", "1821", PackageType.AXXXXXXX_S));
        this.packages.add(new Package("8716", "1811", PackageType.AXXXXXXX_S));
        this.packages.add(new Package("8676", "1581", PackageType.AXXXXXXX_S));
        this.packages.add(new Package("8746", "1181", PackageType.AXXXXXXX_S));
    }
}
