package office.shareoffice.domain.api.login;

public class LoginFactory {
    public Login createLogin(String type){

        Login login = null;

        switch (type) {
            case "kakao":
                break;
            case "naver":
                break;
            case "google":
                break;
        }
        return login;

    }
}
