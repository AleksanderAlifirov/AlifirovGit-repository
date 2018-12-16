import org.openqa.selenium.chrome.ChromeDriver

/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/#configuration
*/

waiting {
    timeout = 6
    retryInterval = 0.5
    slow { timeout = 12 }
    reallyslow { timeout = 24 }
}

driver = { new ChromeDriver() }

environments {
    chrome {
        driver = { new ChromeDriver() }
    }
}

atCheckWaiting = 'normalPage'
System.setProperty("webdriver.chrome.driver", "webdriver\\chromedriver\\chromedriver.exe")
baseUrl = "http://www.rzd.ru"
reportsDir = new File("build/runtime_reports_dir")
