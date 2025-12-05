package xyz.recallfor.jvm.ergonomics;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.text.NumberFormat;

public class App 
{
    public static void main( String[] args )
    {
        Runtime runtime = Runtime.getRuntime();
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        NumberFormat formatter = NumberFormat.getInstance();

        int availableProcessors = runtime.availableProcessors();
        long totalMemoryMb = runtime.totalMemory() / 1_048_576;
        long maxMemoryMb = runtime.maxMemory() / 1_048_576;
        long freeMemoryMb = runtime.freeMemory() / 1_048_576;
        long totalPhysicalMemoryMb = osBean.getTotalPhysicalMemorySize() / 1_048_576;

        System.out.println("App: available processors: " + availableProcessors);
        System.out.println("App: total physical RAM: " + formatter.format(totalPhysicalMemoryMb) + " MB");
        System.out.println("App: JVM total memory: " + formatter.format(totalMemoryMb) + " MB");
        System.out.println("App: max memory: " + formatter.format(maxMemoryMb) + " MB");
        System.out.println("App: free memory: " + formatter.format(freeMemoryMb) + " MB");
    }
}
