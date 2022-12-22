package app.bersama;

import app.bersama.enums.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

/**
 * @author regiewby on 20/12/22
 * @project java-cucumber-mobile
 */
public class Keyword {

    private static final AppiumDriver driver = DriverManager.getInstance().getDriver();

    public static void enterText(WebElement element, String value) {
        waitUntilElementIsVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickAble(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private static void swipe(Point source, Point target) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                source.getX(),
                source.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(700),
                PointerInput.Origin.viewport(),
                target.getX(),
                target.y));
        driver.perform(Collections.singleton(swipe));
    }

    public static void swipe(Direction direction) {
        int height;
        int width;

        height = driver.manage().window().getSize().getHeight();
        width = driver.manage().window().getSize().getWidth();

        int startX = width / 2, startY = 0, endX = width / 2, endY = 0;

        if (direction.equals(Direction.UP)) {
            startY = (int) (height * 0.2);
            endY = (int) (height * 0.8);
        } else if (direction.equals(Direction.DOWN)) {
            startY = (int) (height * 0.8);
            endY = (int) (height * 0.2);
        }

        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);

        swipe(end, start);
    }

    public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        Point source = sourceElement.getLocation();
        Point target = targetElement.getLocation();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        swipe(source, target);
    }


    public static void pullToRefresh() {
        int deviceWidth = driver.manage().window().getSize().getWidth();
        int deviceHeight = driver.manage().window().getSize().getHeight();
        int midX = (deviceWidth / 2);
        int midY = (deviceHeight / 2);
        int bottomEdge = (int) (deviceHeight * 0.85f);
        new TouchAction(driver)
                .press(PointOption.point(midX,midY))
                .waitAction(waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(midX, bottomEdge))
                .release().perform();
    }

    public static void swipeByElement(WebElement startElement, WebElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    public static void swipeScreen(Direction dir) {

        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms
        int edgeBorder = 10; // better avoid edges

        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = DriverManager.getInstance().getDriver().manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        pointOptionEnd = switch (dir) {
            case DOWN -> // center of footer
                    PointOption.point(dims.width / 2, dims.height - edgeBorder);
            case UP -> // center of header
                    PointOption.point(dims.width / 2, edgeBorder);
            case LEFT -> // center of left side
                    PointOption.point(edgeBorder, dims.height / 2);
            case RIGHT -> // center of right side
                    PointOption.point(dims.width - edgeBorder, dims.height / 2);
            default -> throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        };

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
