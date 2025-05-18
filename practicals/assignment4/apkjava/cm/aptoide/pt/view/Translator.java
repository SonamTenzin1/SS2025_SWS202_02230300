package cm.aptoide.pt.view;

import android.content.Context;
import cm.aptoide.pt.R;
import cm.aptoide.pt.updates.UpdatesAnalytics;
import cm.aptoide.pt.utils.AptoideUtils;

@Deprecated
/* loaded from: classes.dex */
public final class Translator {
    public static String translate(String str, Context context, String str2) {
        if (str == null) {
            return str;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2137395588:
                if (str.equals("Health")) {
                    c2 = 0;
                    break;
                }
                break;
            case -2118305922:
                if (str.equals("Game of the Week")) {
                    c2 = 1;
                    break;
                }
                break;
            case -2061360222:
                if (str.equals("Brain & Puzzle")) {
                    c2 = 2;
                    break;
                }
                break;
            case -2031379405:
                if (str.equals("Get rewarded with AppCoins")) {
                    c2 = 3;
                    break;
                }
                break;
            case -2012006303:
                if (str.equals("Timeline")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1892828066:
                if (str.equals("Puzzle")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1854741650:
                if (str.equals("Racing")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1813183603:
                if (str.equals("Social")) {
                    c2 = 7;
                    break;
                }
                break;
            case -1811893345:
                if (str.equals("Sports")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1808199726:
                if (str.equals("Stores")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -1791609619:
                if (str.equals("News & Weather")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -1790955542:
                if (str.equals("Themes")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1781830854:
                if (str.equals("Travel")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -1781592413:
                if (str.equals("Trivia")) {
                    c2 = '\r';
                    break;
                }
                break;
            case -1689537935:
                if (str.equals("Medical")) {
                    c2 = 14;
                    break;
                }
                break;
            case -1644804512:
                if (str.equals("Editors' Choice")) {
                    c2 = 15;
                    break;
                }
                break;
            case -1546396700:
                if (str.equals("Featured Stores")) {
                    c2 = 16;
                    break;
                }
                break;
            case -1530360837:
                if (str.equals("Reviews")) {
                    c2 = 17;
                    break;
                }
                break;
            case -1524721952:
                if (str.equals("Sports Games")) {
                    c2 = 18;
                    break;
                }
                break;
            case -1406873644:
                if (str.equals("Weather")) {
                    c2 = 19;
                    break;
                }
                break;
            case -1283672907:
                if (str.equals("Use Your AppCoins")) {
                    c2 = 20;
                    break;
                }
                break;
            case -1249904381:
                if (str.equals("Earn AppCoins Credits")) {
                    c2 = 21;
                    break;
                }
                break;
            case -1238034679:
                if (str.equals("Transport")) {
                    c2 = 22;
                    break;
                }
                break;
            case -1113305055:
                if (str.equals("Music & Audio")) {
                    c2 = 23;
                    break;
                }
                break;
            case -1112902953:
                if (str.equals("Aptoide Publishers")) {
                    c2 = 24;
                    break;
                }
                break;
            case -1094268730:
                if (str.equals("Music & Video")) {
                    c2 = 25;
                    break;
                }
                break;
            case -1082186784:
                if (str.equals("Business")) {
                    c2 = 26;
                    break;
                }
                break;
            case -1073649596:
                if (str.equals("Essential Apps")) {
                    c2 = 27;
                    break;
                }
                break;
            case -1062937150:
                if (str.equals("Followed Stores")) {
                    c2 = 28;
                    break;
                }
                break;
            case -1049499468:
                if (str.equals("Comments on this store")) {
                    c2 = 29;
                    break;
                }
                break;
            case -1039412629:
                if (str.equals("Multimedia")) {
                    c2 = 30;
                    break;
                }
                break;
            case -978294581:
                if (str.equals("Downloads")) {
                    c2 = 31;
                    break;
                }
                break;
            case -961061219:
                if (str.equals("Top Apps")) {
                    c2 = ' ';
                    break;
                }
                break;
            case -955424387:
                if (str.equals("Photography")) {
                    c2 = '!';
                    break;
                }
                break;
            case -897418454:
                if (str.equals("Health & Fitness")) {
                    c2 = '\"';
                    break;
                }
                break;
            case -857147262:
                if (str.equals("AppCoins Enabled")) {
                    c2 = '#';
                    break;
                }
                break;
            case -733713896:
                if (str.equals("News & Magazines")) {
                    c2 = '$';
                    break;
                }
                break;
            case -704707964:
                if (str.equals("Role Playing")) {
                    c2 = '%';
                    break;
                }
                break;
            case -658248308:
                if (str.equals("Cards & Casino")) {
                    c2 = '&';
                    break;
                }
                break;
            case -579226340:
                if (str.equals("Latest Applications")) {
                    c2 = '\'';
                    break;
                }
                break;
            case -570295317:
                if (str.equals("Travel & Local")) {
                    c2 = '(';
                    break;
                }
                break;
            case -559276497:
                if (str.equals("Apps Timeline")) {
                    c2 = ')';
                    break;
                }
                break;
            case -352711613:
                if (str.equals("Summer Apps")) {
                    c2 = '*';
                    break;
                }
                break;
            case -335032828:
                if (str.equals("Personalization")) {
                    c2 = '+';
                    break;
                }
                break;
            case -279816824:
                if (str.equals("Shopping")) {
                    c2 = ',';
                    break;
                }
                break;
            case -236322890:
                if (str.equals("Communication")) {
                    c2 = '-';
                    break;
                }
                break;
            case -226683580:
                if (str.equals("Libraries & Demo")) {
                    c2 = '.';
                    break;
                }
                break;
            case -161518821:
                if (str.equals("Books & Reference")) {
                    c2 = '/';
                    break;
                }
                break;
            case -140581837:
                if (str.equals("Highlighted")) {
                    c2 = '0';
                    break;
                }
                break;
            case 65921:
                if (str.equals("All")) {
                    c2 = '1';
                    break;
                }
                break;
            case 2092848:
                if (str.equals("Card")) {
                    c2 = '2';
                    break;
                }
                break;
            case 2126339:
                if (str.equals("Demo")) {
                    c2 = '3';
                    break;
                }
                break;
            case 2255103:
                if (str.equals("Home")) {
                    c2 = '4';
                    break;
                }
                break;
            case 2702122:
                if (str.equals("Word")) {
                    c2 = '5';
                    break;
                }
                break;
            case 64356038:
                if (str.equals("Board")) {
                    c2 = '6';
                    break;
                }
                break;
            case 68567713:
                if (str.equals("Games")) {
                    c2 = '7';
                    break;
                }
                break;
            case 74710533:
                if (str.equals("Music")) {
                    c2 = '8';
                    break;
                }
                break;
            case 80992699:
                if (str.equals("Tools")) {
                    c2 = '9';
                    break;
                }
                break;
            case 111439712:
                if (str.equals("Software Libraries")) {
                    c2 = ':';
                    break;
                }
                break;
            case 276964342:
                if (str.equals("Top Games")) {
                    c2 = ';';
                    break;
                }
                break;
            case 357128477:
                if (str.equals("Top Stores")) {
                    c2 = '<';
                    break;
                }
                break;
            case 471515264:
                if (str.equals("Arcade & Action")) {
                    c2 = '=';
                    break;
                }
                break;
            case 523718601:
                if (str.equals("Community")) {
                    c2 = '>';
                    break;
                }
                break;
            case 701694503:
                if (str.equals("Simulation")) {
                    c2 = '?';
                    break;
                }
                break;
            case 710918574:
                if (str.equals("Comments in this store")) {
                    c2 = '@';
                    break;
                }
                break;
            case 811395002:
                if (str.equals("Finance")) {
                    c2 = 'A';
                    break;
                }
                break;
            case 857024639:
                if (str.equals("Featured AppCoins Apps")) {
                    c2 = 'B';
                    break;
                }
                break;
            case 891620482:
                if (str.equals("Latest Reviews")) {
                    c2 = 'C';
                    break;
                }
                break;
            case 927605132:
                if (str.equals("Transportation")) {
                    c2 = 'D';
                    break;
                }
                break;
            case 983921684:
                if (str.equals("The cryptocurrency for the app economy is here! Get free AppCoins by using your favorite apps.")) {
                    c2 = 'E';
                    break;
                }
                break;
            case 994268114:
                if (str.equals("Local Top Apps")) {
                    c2 = 'F';
                    break;
                }
                break;
            case 1078812459:
                if (str.equals("Reference")) {
                    c2 = 'G';
                    break;
                }
                break;
            case 1101527363:
                if (str.equals("Applications")) {
                    c2 = 'H';
                    break;
                }
                break;
            case 1188177138:
                if (str.equals("Productivity")) {
                    c2 = 'I';
                    break;
                }
                break;
            case 1298968424:
                if (str.equals("Entertainment")) {
                    c2 = 'J';
                    break;
                }
                break;
            case 1309873904:
                if (str.equals("Adventure")) {
                    c2 = 'K';
                    break;
                }
                break;
            case 1413249359:
                if (str.equals("You can get AppCoins now!")) {
                    c2 = 'L';
                    break;
                }
                break;
            case 1423561139:
                if (str.equals("Educational")) {
                    c2 = 'M';
                    break;
                }
                break;
            case 1430223018:
                if (str.equals(UpdatesAnalytics.UPDATE_EVENT)) {
                    c2 = 'N';
                    break;
                }
                break;
            case 1459599685:
                if (str.equals("Trending")) {
                    c2 = 'O';
                    break;
                }
                break;
            case 1529205357:
                if (str.equals("Latest Comments")) {
                    c2 = 'P';
                    break;
                }
                break;
            case 1559628443:
                if (str.equals("Editors Choice")) {
                    c2 = 'Q';
                    break;
                }
                break;
            case 1639783301:
                if (str.equals("Media & Video")) {
                    c2 = 'R';
                    break;
                }
                break;
            case 1713211272:
                if (str.equals("Education")) {
                    c2 = 'S';
                    break;
                }
                break;
            case 1716292629:
                if (str.equals("Lifestyle")) {
                    c2 = 'T';
                    break;
                }
                break;
            case 1753516375:
                if (str.equals("Recommended Stores")) {
                    c2 = 'U';
                    break;
                }
                break;
            case 1785707127:
                if (str.equals("Top Apps in this store")) {
                    c2 = 'V';
                    break;
                }
                break;
            case 1852442515:
                if (str.equals("Strategy")) {
                    c2 = 'W';
                    break;
                }
                break;
            case 1855032658:
                if (str.equals("Apps for Kids")) {
                    c2 = 'X';
                    break;
                }
                break;
            case 1887347784:
                if (str.equals("Editor's Choice")) {
                    c2 = 'Y';
                    break;
                }
                break;
            case 1942241885:
                if (str.equals("Play-it!")) {
                    c2 = 'Z';
                    break;
                }
                break;
            case 1955883606:
                if (str.equals("Action")) {
                    c2 = '[';
                    break;
                }
                break;
            case 1969221936:
                if (str.equals("Arcade")) {
                    c2 = '\\';
                    break;
                }
                break;
            case 2011265045:
                if (str.equals("Casino")) {
                    c2 = ']';
                    break;
                }
                break;
            case 2011276171:
                if (str.equals("Casual")) {
                    c2 = '^';
                    break;
                }
                break;
            case 2024015256:
                if (str.equals("Comics")) {
                    c2 = '_';
                    break;
                }
                break;
            case 2043863915:
                if (str.equals("Latest Apps")) {
                    c2 = '`';
                    break;
                }
                break;
            case 2060928108:
                if (str.equals("Spend your AppCoins")) {
                    c2 = 'a';
                    break;
                }
                break;
            case 2096973700:
                if (str.equals("Family")) {
                    c2 = 'b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return context.getString(R.string.health);
            case 1:
                return context.getString(R.string.home_game_of_the_week);
            case 2:
                return context.getString(R.string.brain_puzzle);
            case 3:
                return context.getString(R.string.appc_title_ads);
            case 4:
                return context.getString(R.string.timeline);
            case 5:
                return context.getString(R.string.puzzle);
            case 6:
                return context.getString(R.string.racing);
            case 7:
                return context.getString(R.string.social);
            case '\b':
                return context.getString(R.string.sports);
            case '\t':
                return context.getString(R.string.stores);
            case '\n':
                return context.getString(R.string.news_weather);
            case 11:
                return context.getString(R.string.themes);
            case '\f':
                return context.getString(R.string.travel);
            case '\r':
                return context.getString(R.string.trivia);
            case 14:
                return context.getString(R.string.medical);
            case 15:
            case 'Q':
            case 'Y':
                return context.getString(R.string.home_title_editors_choice);
            case 16:
                return context.getString(R.string.featured_stores);
            case 17:
                return context.getString(R.string.reviews);
            case 18:
                return context.getString(R.string.sports_games);
            case 19:
                return context.getString(R.string.weather);
            case 20:
                return context.getString(R.string.appc_home_bundle_iab);
            case 21:
                return context.getString(R.string.appc_home_bundle_poa);
            case 22:
                return context.getString(R.string.transport);
            case 23:
                return context.getString(R.string.music_audio);
            case 24:
                return AptoideUtils.StringU.getFormattedString(R.string.aptoide_publishers, context.getResources(), str2);
            case 25:
                return context.getString(R.string.music_video);
            case 26:
                return context.getString(R.string.business);
            case 27:
                return context.getString(R.string.essential_apps);
            case 28:
                return context.getString(R.string.followed_stores);
            case 29:
            case '@':
                return context.getString(R.string.comment_store_title);
            case 30:
                return context.getString(R.string.multimedia);
            case 31:
                return context.getString(R.string.downloads);
            case ' ':
                return context.getString(R.string.top_apps);
            case '!':
                return context.getString(R.string.photography);
            case '\"':
                return context.getString(R.string.health_fitness);
            case '#':
            case 'a':
                return context.getString(R.string.appc_title_iab);
            case '$':
                return context.getString(R.string.news_magazines);
            case '%':
                return context.getString(R.string.role_playing);
            case '&':
                return context.getString(R.string.cards_casino);
            case '\'':
            case '`':
                return context.getString(R.string.latest_applications);
            case '(':
                return context.getString(R.string.travel_local);
            case ')':
                return context.getString(R.string.apps_timeline);
            case '*':
                return context.getString(R.string.summer_apps);
            case '+':
                return context.getString(R.string.personalization);
            case ',':
                return context.getString(R.string.shopping);
            case '-':
                return context.getString(R.string.communication);
            case '.':
                return context.getString(R.string.libraries_demo);
            case '/':
                return context.getString(R.string.books_reference);
            case '0':
                return context.getString(R.string.highlighted);
            case '1':
                return context.getString(R.string.all);
            case '2':
                return context.getString(R.string.card);
            case '3':
                return context.getString(R.string.demo);
            case '4':
                return context.getString(R.string.home_title);
            case '5':
                return context.getString(R.string.word);
            case '6':
                return context.getString(R.string.board);
            case '7':
                return context.getString(R.string.games);
            case '8':
                return context.getString(R.string.music);
            case '9':
                return context.getString(R.string.tools);
            case ':':
                return context.getString(R.string.software_libraries);
            case ';':
                return context.getString(R.string.top_games);
            case '<':
                return context.getString(R.string.top_stores_fragment_title);
            case '=':
                return context.getString(R.string.arcade_action);
            case '>':
                return context.getString(R.string.community);
            case '?':
                return context.getString(R.string.simulation);
            case 'A':
                return context.getString(R.string.finance);
            case 'B':
                return context.getString(R.string.appc_title_featured);
            case 'C':
                return context.getString(R.string.latest_reviews);
            case 'D':
                return context.getString(R.string.transportation);
            case 'E':
                return context.getString(R.string.appc_message_homepage_card);
            case 'F':
                return context.getString(R.string.local_top_apps);
            case 'G':
                return context.getString(R.string.reference);
            case 'H':
                return context.getString(R.string.applications);
            case 'I':
                return context.getString(R.string.productivity);
            case 'J':
                return context.getString(R.string.entertainment);
            case 'K':
                return context.getString(R.string.adventure);
            case 'L':
                return context.getString(R.string.appc_title_homepage_card);
            case 'M':
                return context.getString(R.string.educational);
            case 'N':
                return context.getString(R.string.updates);
            case 'O':
                return context.getString(R.string.trending);
            case 'P':
                return context.getString(R.string.latest_comments);
            case 'R':
                return context.getString(R.string.media_video);
            case 'S':
                return context.getString(R.string.education);
            case 'T':
                return context.getString(R.string.lifestyle);
            case 'U':
                return context.getString(R.string.recommended_stores);
            case 'V':
                return context.getString(R.string.top_apps_in_store);
            case 'W':
                return context.getString(R.string.strategy);
            case 'X':
                return context.getString(R.string.apps_for_kids);
            case 'Z':
                return context.getString(R.string.title_play_it);
            case '[':
                return context.getString(R.string.action);
            case '\\':
                return context.getString(R.string.arcade);
            case ']':
                return context.getString(R.string.casino);
            case '^':
                return context.getString(R.string.casual);
            case '_':
                return context.getString(R.string.comics);
            case 'b':
                return context.getString(R.string.family);
            default:
                return str;
        }
    }

    public static String[] translateToMultiple(String str, Context context) {
        if (str == null) {
            return null;
        }
        if (str.equals("Your store does not have any applications yet. Install Aptoide Uploader and upload apps to share them with the world!") || str.equals("Your store doesn't have any applications yet. Install Aptoide Uploader and upload apps to share them with the world!")) {
            return new String[]{context.getString(R.string.install_app_outter_pt1), context.getString(R.string.install_app_outter_pt2), context.getString(R.string.install_app_inner), context.getString(R.string.open_app_inner)};
        }
        return null;
    }
}
