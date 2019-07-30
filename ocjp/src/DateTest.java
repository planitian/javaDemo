import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.time.LocalTime;
        import java.time.Period;
        import java.time.format.DateTimeFormatter;
        import java.time.temporal.ChronoUnit;

public class DateTest {
    public static void main(String[] args) {
        //生成一个时间
        LocalDate localDate = LocalDate.of(2012, 3, 23);
        //当前时间
        LocalDate now = LocalDate.now();
        //是否在之前
        System.out.println(localDate.isBefore(now));
        //间隔
        Period period = Period.ofYears(1);
        //加时间
        LocalDate localDate1 = localDate.plus(period);
        System.out.println(localDate1);
        //本地时间
        LocalTime localTime = LocalTime.of(10, 12);
        //本地日期时间
        LocalDateTime localDateTime = LocalDateTime.of(localDate1, localTime);
        System.out.println(localDateTime);
        //时间格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(format);
        LocalDate local = LocalDate.parse(format, dateTimeFormatter);
        System.out.println(local);
        System.out.println(local.getDayOfMonth());
        //算出 从开到 到结束时间
        long days = local.until(LocalDate.now(), ChronoUnit.DAYS);
        System.out.println(days);
        //时间间隔
        Period period1 = Period.between(localDate, LocalDate.now());
        System.out.println(period1.getDays());


    }
}
