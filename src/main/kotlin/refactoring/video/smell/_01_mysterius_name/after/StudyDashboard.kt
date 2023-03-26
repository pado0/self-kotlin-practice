package refactoring.video.smell._01_mysterius_name.after

import org.kohsuke.github.GitHub

class StudyDashboard {

    /**
     * 리팩토링 3. 필드 이름 바꾸기
     * username보단, 전반적으로 사용되는 변수이니 reviewrs 정도로 바꿔보자.
     */
    val reviewrs = hashSetOf<String>()
    val reviews = hashSetOf<String>()

    /** 리팩토링 1. 함수 선언 변경하기
     * 함수의 이름을 짓기 위해 함수가 뭐하는 애인지 주석을 써본다.
     * - 스터디 리뷰 이슈에 작성되어있는 리뷰어 목록과 리뷰를 읽어옵니다.
     * 위에 쓴 주석을 바탕으로 이 함수의 이름을 변경한다. studyReviews -> loadReviews
     */

    fun loadReviews() {

        /**
         * 리팩토링 1. 함수 선언 변경하기
         * 매개변수로 issue를 받고있었는데, 어차피 이슈가 30번으로 고정되어있으니 본 함수 안에서 이슈 세팅까지 해도 괜찮을 것 같다.
         */
        val gitHub = GitHub.connect()
        val repository = gitHub.getRepository("whiteship/live-study")
        val issue = repository.getIssue(30)

        /**
         * 리팩토링 2. 리뷰를 읽어오는 함수이므로 변수명을 리뷰로 바꾼다
         */
        val reviews = issue.comments
        reviews.forEach {
            reviewrs.add(it.userName)
            reviewrs.add(it.body)
        }
    }
}

fun main() {

    val studyDashboard: StudyDashboard = StudyDashboard()
    studyDashboard.loadReviews()

    /**
     * 리팩토링 2. 람다식은 scope가 매우 작으니 굳이 변수명을 구체화할 필요 없을 수 있다. (햔헹 유지)
     */
    studyDashboard.reviewrs.forEach{ println(it) }
    studyDashboard.reviews.forEach{ println(it) }

}