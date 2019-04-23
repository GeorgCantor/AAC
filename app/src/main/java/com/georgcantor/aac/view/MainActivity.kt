package com.georgcantor.aac.view

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.georgcantor.aac.R
import com.georgcantor.aac.view.fragment.NewsFragment
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem

class MainActivity : AppCompatActivity() {

    private lateinit var newsFragment: Fragment
    private lateinit var source: String
    private var result: Drawer? = null

    private val sources = arrayOf("abc-news-au", "associated-press", "bbc-news",
            "cnn", "google-news", "independent", "metro", "mirror", "newsweek", "new-york-magazine",
            "reuters", "the-huffington-post", "the-new-york-times", "time", "usa-today", "bloomberg",
            "business-insider", "the-economist", "buzzfeed", "daily-mail", "entertainment-weekly",
            "mashable", "mtv-news", "the-lad-bible", "bbc-sport", "espn", "football-italia",
            "four-four-two", "ars-technica", "engadget", "techcrunch", "techradar", "the-verge",
            "national-geographic", "new-scientist", "ign", "polygon", "breitbart-news",
            "the-telegraph", "the-washington-post", "recode", "reddit-r-all", "the-next-web",
            "the-wall-street-journal", "fortune", "cnbc", "talksport", "nfl-news", "nhl-news",
            "msnbc", "national-review", "next-big-future", "the-american-conservative", "the-hill",
            "crypto-coins-news", "financial-post", "axios", "fox-news", "medical-news-today",
            "cbs-news", "cbc-news", "hacker-news", "nbc-news", "the-sport-bible", "vice-news",
            "bleacher-report")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsFragment = NewsFragment()
        if (savedInstanceState == null) {
            loadFragment(newsFragment)
        }

        createDrawer(savedInstanceState, null, null)
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun createDrawer(savedInstanceState: Bundle?,
                             toolbar: Toolbar?,
                             typeface: Typeface?) {
        val item0 = PrimaryDrawerItem().withIdentifier(0)
                .withName("GENERAL").withTypeface(typeface).withSelectable(false)
        val item1 = PrimaryDrawerItem().withIdentifier(1)
                .withName("ABC News").withIcon(R.drawable.abc).withTypeface(typeface)
        val item2 = PrimaryDrawerItem().withIdentifier(2)
                .withName("Associated Press").withIcon(R.drawable.abc).withTypeface(typeface)
        val item3 = PrimaryDrawerItem().withIdentifier(3)
                .withName("BBC News").withIcon(R.drawable.abc).withTypeface(typeface)
        val item4 = PrimaryDrawerItem().withIdentifier(4)
                .withName("CNN").withIcon(R.drawable.abc).withTypeface(typeface)
        val item5 = PrimaryDrawerItem().withIdentifier(5)
                .withName("Google News").withIcon(R.drawable.abc).withTypeface(typeface)
        val item6 = PrimaryDrawerItem().withIdentifier(6)
                .withName("Independent").withIcon(R.drawable.abc).withTypeface(typeface)
        val item7 = PrimaryDrawerItem().withIdentifier(7)
                .withName("Metro").withIcon(R.drawable.abc).withTypeface(typeface)
        val item8 = PrimaryDrawerItem().withIdentifier(8)
                .withName("Mirror").withIcon(R.drawable.abc).withTypeface(typeface)
        val item9 = PrimaryDrawerItem().withIdentifier(9)
                .withName("Newsweek").withIcon(R.drawable.abc).withTypeface(typeface)
        val item10 = PrimaryDrawerItem().withIdentifier(10)
                .withName("New York Magazine").withIcon(R.drawable.abc).withTypeface(typeface)
//        val item11 = PrimaryDrawerItem().withIdentifier(11)
//                .withName("Reuters").withIcon(R.drawable.reuters).withTypeface(typeface)
//        val item12 = PrimaryDrawerItem().withIdentifier(12)
//                .withName("The Huffington Post").withIcon(R.drawable.huffington_icon).withTypeface(typeface)
//        val item13 = PrimaryDrawerItem().withIdentifier(13)
//                .withName("The New York Times").withIcon(R.drawable.nytimes).withTypeface(typeface)
//        val item14 = PrimaryDrawerItem().withIdentifier(14)
//                .withName("Time").withIcon(R.drawable.time).withTypeface(typeface)
//        val item15 = PrimaryDrawerItem().withIdentifier(15)
//                .withName("USA Today").withIcon(R.drawable.usa_today).withTypeface(typeface)
//        val item16 = SectionDrawerItem().withIdentifier(16)
//                .withName("BUSINESS").withTypeface(typeface)
//        val item17 = PrimaryDrawerItem().withIdentifier(17)
//                .withName("Bloomberg").withIcon(R.drawable.bloomberg).withTypeface(typeface)
//        val item18 = PrimaryDrawerItem().withIdentifier(18)
//                .withName("Business Insider").withIcon(R.drawable.business_ins).withTypeface(typeface)
//        val item19 = PrimaryDrawerItem().withIdentifier(19)
//                .withName("The Economist").withIcon(R.drawable.economist).withTypeface(typeface)
//        val item20 = SectionDrawerItem().withIdentifier(20)
//                .withName("ENTERTAINMENT").withTypeface(typeface)
//        val item21 = PrimaryDrawerItem().withIdentifier(21)
//                .withName("Buzzfeed").withIcon(R.drawable.buzz).withTypeface(typeface)
//        val item22 = PrimaryDrawerItem().withIdentifier(22)
//                .withName("Daily Mail").withIcon(R.drawable.daily_mail).withTypeface(typeface)
//        val item23 = PrimaryDrawerItem().withIdentifier(23)
//                .withName("Entertainment Weekly").withIcon(R.drawable.ew).withTypeface(typeface)
//        val item24 = PrimaryDrawerItem().withIdentifier(24)
//                .withName("Mashable").withIcon(R.drawable.mashable).withTypeface(typeface)
//        val item25 = PrimaryDrawerItem().withIdentifier(25)
//                .withName("MTV News").withIcon(R.drawable.ic_mtvnews).withTypeface(typeface)
//        val item26 = PrimaryDrawerItem().withIdentifier(26)
//                .withName("The Lad Bible").withIcon(R.drawable.ladbible).withTypeface(typeface)
//        val item27 = SectionDrawerItem().withIdentifier(27)
//                .withName("SPORT").withTypeface(typeface)
//        val item28 = PrimaryDrawerItem().withIdentifier(28)
//                .withName("BBC Sport").withIcon(R.drawable.ic_bbcsports).withTypeface(typeface)
//        val item29 = PrimaryDrawerItem().withIdentifier(29)
//                .withName("ESPN").withIcon(R.drawable.espn).withTypeface(typeface)
//        val item30 = PrimaryDrawerItem().withIdentifier(30)
//                .withName("Football Italia").withIcon(R.drawable.football_it).withTypeface(typeface)
//        val item31 = PrimaryDrawerItem().withIdentifier(31)
//                .withName("FourFourTwo").withIcon(R.drawable.fourfourtwo).withTypeface(typeface)
//        val item32 = SectionDrawerItem().withIdentifier(32)
//                .withName("TECHNOLOGY").withTypeface(typeface)
//        val item33 = PrimaryDrawerItem().withIdentifier(33)
//                .withName("Ars Technica").withIcon(R.drawable.ars).withTypeface(typeface)
//        val item34 = PrimaryDrawerItem().withIdentifier(34)
//                .withName("Engadget").withIcon(R.drawable.engadget).withTypeface(typeface)
//        val item35 = PrimaryDrawerItem().withIdentifier(35)
//                .withName("TechCrunch").withIcon(R.drawable.tech_crunch).withTypeface(typeface)
//        val item36 = PrimaryDrawerItem().withIdentifier(36)
//                .withName("TechRadar").withIcon(R.drawable.ic_techradar).withTypeface(typeface)
//        val item37 = PrimaryDrawerItem().withIdentifier(37)
//                .withName("The Verge").withIcon(R.drawable.ic_theverge).withTypeface(typeface)
//        val item38 = SectionDrawerItem().withIdentifier(38)
//                .withName("SCIENCE & NATURE").withTypeface(typeface)
//        val item39 = PrimaryDrawerItem().withIdentifier(39)
//                .withName("National Geographic").withIcon(R.drawable.ng).withTypeface(typeface)
//        val item40 = PrimaryDrawerItem().withIdentifier(40)
//                .withName("New Scientist").withIcon(R.drawable.new_scientist).withTypeface(typeface)
//        val item41 = SectionDrawerItem().withIdentifier(41)
//                .withName("GAMING").withTypeface(typeface)
//        val item42 = PrimaryDrawerItem().withIdentifier(42)
//                .withName("IGN").withIcon(R.drawable.ign).withTypeface(typeface)
//        val item43 = PrimaryDrawerItem().withIdentifier(43)
//                .withName("Polygon").withIcon(R.drawable.polygon).withTypeface(typeface)
//        val item44 = SectionDrawerItem().withIdentifier(44)
//                .withName("POLITICS").withTypeface(typeface)
//        val item45 = PrimaryDrawerItem().withIdentifier(45)
//                .withName("Breitbart News").withIcon(R.drawable.breitbart).withTypeface(typeface)
//        val item46 = PrimaryDrawerItem().withIdentifier(46)
//                .withName("The Telegraph").withIcon(R.drawable.telegraph).withTypeface(typeface)
//        val item47 = PrimaryDrawerItem().withIdentifier(47)
//                .withName("The Washington Post").withIcon(R.drawable.washingtonpost).withTypeface(typeface)
//        val item48 = SectionDrawerItem().withIdentifier(48)
//                .withName("OTHER").withTypeface(typeface)
//        val item49 = PrimaryDrawerItem().withIdentifier(49)
//                .withName("Recode").withIcon(R.drawable.recode).withTypeface(typeface)
//        val item50 = PrimaryDrawerItem().withIdentifier(50)
//                .withName("Reddit").withIcon(R.drawable.reddit).withTypeface(typeface)
//        val item51 = PrimaryDrawerItem().withIdentifier(51)
//                .withName("The Next Web").withIcon(R.drawable.tnw).withTypeface(typeface)
//        val item52 = PrimaryDrawerItem().withIdentifier(52)
//                .withName("The Wall Street Journal").withIcon(R.drawable.wsj).withTypeface(typeface)
//        val item53 = PrimaryDrawerItem().withIdentifier(53)
//                .withName("Fortune").withIcon(R.drawable.fortune).withTypeface(typeface)
//        val item54 = PrimaryDrawerItem().withIdentifier(54)
//                .withName("CNBC").withIcon(R.drawable.cnbc).withTypeface(typeface)
//        val item55 = PrimaryDrawerItem().withIdentifier(55)
//                .withName("TalkSport").withIcon(R.drawable.talck_sport).withTypeface(typeface)
//        val item56 = PrimaryDrawerItem().withIdentifier(56)
//                .withName("NFL.com").withIcon(R.drawable.nfl_icon).withTypeface(typeface)
//        val item57 = PrimaryDrawerItem().withIdentifier(57)
//                .withName("NHL.com").withIcon(R.drawable.nhl).withTypeface(typeface)
//        val item58 = PrimaryDrawerItem().withIdentifier(58)
//                .withName("MSNBC").withIcon(R.drawable.msnbc).withTypeface(typeface)
//        val item59 = PrimaryDrawerItem().withIdentifier(59)
//                .withName("National Review").withIcon(R.drawable.nr).withTypeface(typeface)
//        val item60 = PrimaryDrawerItem().withIdentifier(60)
//                .withName("Next Big Future").withIcon(R.drawable.next_b_f).withTypeface(typeface)
//        val item61 = PrimaryDrawerItem().withIdentifier(61)
//                .withName("The American Conservative").withIcon(R.drawable.the_am_cons).withTypeface(typeface)
//        val item62 = PrimaryDrawerItem().withIdentifier(62)
//                .withName("The Hill").withIcon(R.drawable.the_hill).withTypeface(typeface)
//        val item63 = PrimaryDrawerItem().withIdentifier(63)
//                .withName("Crypto Coins News").withIcon(R.drawable.ccn).withTypeface(typeface)
//        val item64 = PrimaryDrawerItem().withIdentifier(64)
//                .withName("Financial Post").withIcon(R.drawable.fin_post).withTypeface(typeface)
//        val item65 = PrimaryDrawerItem().withIdentifier(65)
//                .withName("Axios").withIcon(R.drawable.axios).withTypeface(typeface)
//        val item66 = PrimaryDrawerItem().withIdentifier(66)
//                .withName("Fox News").withIcon(R.drawable.foxnews).withTypeface(typeface)
//        val item67 = PrimaryDrawerItem().withIdentifier(67)
//                .withName("Medical News Today").withIcon(R.drawable.mnt).withTypeface(typeface)
//        val item68 = PrimaryDrawerItem().withIdentifier(68)
//                .withName("CBS News").withIcon(R.drawable.cbsnews).withTypeface(typeface)
//        val item69 = PrimaryDrawerItem().withIdentifier(69)
//                .withName("CBC News").withIcon(R.drawable.cbc).withTypeface(typeface)
//        val item70 = PrimaryDrawerItem().withIdentifier(70)
//                .withName("Hacker News").withIcon(R.drawable.hn).withTypeface(typeface)
//        val item71 = PrimaryDrawerItem().withIdentifier(71)
//                .withName("NBC News").withIcon(R.drawable.nbc).withTypeface(typeface)
//        val item72 = PrimaryDrawerItem().withIdentifier(72)
//                .withName("The Sport Bible").withIcon(R.drawable.sport_bible).withTypeface(typeface)
//        val item73 = PrimaryDrawerItem().withIdentifier(73)
//                .withName("Vice News").withIcon(R.drawable.vn).withTypeface(typeface)
//        val item74 = PrimaryDrawerItem().withIdentifier(74)
//                .withName("Bleacher Report").withIcon(R.drawable.vn).withTypeface(typeface)
//        val item75 = SectionDrawerItem().withIdentifier(75)
//                .withName("MOVIES").withTypeface(typeface)
//        val item76 = PrimaryDrawerItem().withIdentifier(76)
//                .withName("Latest Movies").withIcon(R.drawable.movie_icon).withTypeface(typeface)

        result = DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar!!)
                .withSelectedItem(1)
                .addDrawerItems(item0, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10
//                        item11, item12, item13, item14, item15, item16, item17, item18, item19,
//                        item20, item21, item22, item23, item24, item25, item26, item27, item28, item29,
//                        item30, item31, item32, item33, item34, item35, item36, item37, item38, item39,
//                        item40, item41, item42, item43, item44, item45, item46, item47, item48, item49,
//                        item50, item51, item52, item53, item54, item55, item56, item57, item58, item59,
//                        item60, item61, item62, item63, item64, item65, item66, item67, item68, item69,
//                        item70, item71, item72, item73, item74, item75, item76
                )

                .withOnDrawerItemClickListener { _, _, drawerItem ->
                    val selected = drawerItem.identifier.toInt()
                    when (selected) {
                        1 -> {
                            source = sources[0]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
                        2 -> {
                            source = sources[1]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
                        3 -> {
                            source = sources[2]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
                        4 -> {
                            source = sources[3]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
                        5 -> {
                            source = sources[4]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
                        6 -> {
                            source = sources[5]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
                        7 -> {
                            source = sources[6]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
                        8 -> {
                            source = sources[7]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
                        9 -> {
                            source = sources[8]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
                        10 -> {
                            source = sources[9]
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
                        }
//                        11 -> {
//                            source = sourceArray[10]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        12 -> {
//                            source = sourceArray[11]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        13 -> {
//                            source = sourceArray[12]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        14 -> {
//                            source = sourceArray[13]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        15 -> {
//                            source = sourceArray[14]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        17 -> {
//                            source = sourceArray[15]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        18 -> {
//                            source = sourceArray[16]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        19 -> {
//                            source = sourceArray[17]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        21 -> {
//                            source = sourceArray[18]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        22 -> {
//                            source = sourceArray[19]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        23 -> {
//                            source = sourceArray[20]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        24 -> {
//                            source = sourceArray[21]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        25 -> {
//                            source = sourceArray[22]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        26 -> {
//                            source = sourceArray[23]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        28 -> {
//                            source = sourceArray[24]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        29 -> {
//                            source = sourceArray[25]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        30 -> {
//                            source = sourceArray[26]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        31 -> {
//                            source = sourceArray[27]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        33 -> {
//                            source = sourceArray[28]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        34 -> {
//                            source = sourceArray[29]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        35 -> {
//                            source = sourceArray[30]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        36 -> {
//                            source = sourceArray[31]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        37 -> {
//                            source = sourceArray[32]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        39 -> {
//                            source = sourceArray[33]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        40 -> {
//                            source = sourceArray[34]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        42 -> {
//                            source = sourceArray[35]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        43 -> {
//                            source = sourceArray[36]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        45 -> {
//                            source = sourceArray[37]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        46 -> {
//                            source = sourceArray[38]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        47 -> {
//                            source = sourceArray[39]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        49 -> {
//                            source = sourceArray[40]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        50 -> {
//                            source = sourceArray[41]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        51 -> {
//                            source = sourceArray[42]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        52 -> {
//                            source = sourceArray[43]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        53 -> {
//                            source = sourceArray[44]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        54 -> {
//                            source = sourceArray[45]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        55 -> {
//                            source = sourceArray[46]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        56 -> {
//                            source = sourceArray[47]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        57 -> {
//                            source = sourceArray[48]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        58 -> {
//                            source = sourceArray[49]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        59 -> {
//                            source = sourceArray[50]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        60 -> {
//                            source = sourceArray[51]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        61 -> {
//                            source = sourceArray[52]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        62 -> {
//                            source = sourceArray[53]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        63 -> {
//                            source = sourceArray[54]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        64 -> {
//                            source = sourceArray[55]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        65 -> {
//                            source = sourceArray[56]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        66 -> {
//                            source = sourceArray[57]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        67 -> {
//                            source = sourceArray[58]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        68 -> {
//                            source = sourceArray[59]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        69 -> {
//                            source = sourceArray[60]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        70 -> {
//                            source = sourceArray[61]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        71 -> {
//                            source = sourceArray[62]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        72 -> {
//                            source = sourceArray[63]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        73 -> {
//                            source = sourceArray[64]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
//                        74 -> {
//                            source = sourceArray[65]
//                            onLoadingSwipeRefreshLayout()
//                            title!!.text = (drawerItem as Nameable<*>).name.getText(this@MainActivity)
//                        }
                        else -> {
                        }
                    }
                    false
                }
                .withSavedInstance(savedInstanceState)
                .build()
    }
}
