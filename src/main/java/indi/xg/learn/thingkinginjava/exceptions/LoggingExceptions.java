package indi.xg.learn.thingkinginjava.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 异常日志
 * @author chenshixue
 * @date 2020/5/5
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            // new一个异常对象，也就执行了其构造函数
            throw new LoggingException();
        } catch (LoggingException e) {
            // 捕获的这个异常就是上面new的这个LoggingException对象，
            // 该对象里有一个stackTrace属性，保存了异常信息
            System.err.println("Caught" + e);
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught" + e);
        }
    }
}

class LoggingException extends Exception {
    // logger对象会将其输出发送到System.err流
    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        // 日志级别
        logger.severe(trace.toString());
    }
}
