package rzd
import pages.RzdStartPage
import geb.spock.GebReportingSpec
import spock.lang.Ignore


@Ignore
class RzdSpec extends GebReportingSpec {

    def открытьСтартовуюСтраницу(){
        to RzdStartPage
    }
}
