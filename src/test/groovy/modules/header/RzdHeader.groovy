package modules.header

import rzd.RzdModule

class RzdHeader extends RzdModule {

    static content = {

        О_Компании { $("a[href*='://']", text: 'О компании' )}
    }

}
