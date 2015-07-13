import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by ee on 02/07/15.
 */
public class WaitInWebDriver {


    WebDriver driver = new FirefoxDriver();
    List predicates = new ArrayList<Predicate < WebDriver>>() ;

    public void tryPredicates(){

        // implicit wait where explicit condition to be waited for is not specified and this wait applied throughout life cycle of driver.
        driver.manage().timeouts().implicitlyWait(10, SECONDS) ;

        //implicit wait doesnt wait for all the js to be executed on the page.
        //explicit wait using webDriverWait
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        //ExpectedCondition returns you the webelement if present/visible and it internally uses the apply method and takes care of staleness of element
        //If you want ot use consitions already defined in ExpectedCOnditions, its better to use ExpectedConsiions than Predicates
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("blah"))); //throws timeout exception if it doesnt appear in 10 sec.

        //predicate returns only true/false
        //The advantage ofpredicates is that you an create your own conditions using different driver methods avaialble to interact with elements
        webDriverWait.until(new Predicate<WebDriver>(){
            @Override
            public boolean apply(WebDriver driver) {
                return driver.findElement(By.id("blah")).isDisplayed();
            }
        })  ;


    //webdriverwait using Function
    webDriverWait.until(new Function<WebDriver, WebElement>(){
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("blah"));
            }
        })  ;

    }

    //another way
    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30, SECONDS)
            .pollingEvery(5, SECONDS)
            .ignoring(NoSuchElementException.class);


    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
        public WebElement apply(WebDriver driver) {
            return driver.findElement(By.id("foo"));
        }
    });

    /*Guava provides two basic "functional" interfaces:

    Function<A, B>, which has the single method B apply(A input). Instances of Function are generally expected to be referentially transparent -- no side effects -- and to be consistent with equals, that is, a.equals(b) implies that function.apply(a).equals(function.apply(b)).
    Predicate<T>, which has the single method boolean apply(T input). Instances of Predicate are generally expected to be side-effect-free and consistent with equals.
    */



}
