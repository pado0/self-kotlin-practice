package refactoring.video.smell._01_mysterius_name.before

import org.kohsuke.github.GHIssue
import org.kohsuke.github.GitHub

class StudyDashboard {

    val usernames = hashSetOf<String>()
    val reviews = hashSetOf<String>()

    /**
     * 함수의 이름을 짓기 위해 함수가 뭐하는 애인지 주석을 써본다.
     * - 스터디 리뷰 이슈에 작성되어있는 리뷰어 목록과 리뷰를 읽어오는 함수
     * 위에 쓴 주석을 바탕으로 이 함수의 이름을 변경한다.
     */

    fun studyReviews(issue: GHIssue) {
        val comments = issue.comments
        comments.forEach {
            usernames.add(it.userName)
            usernames.add(it.body)
        }
    }
}

fun main() {
    val gitHub = GitHub.connect()
    val repository = gitHub.getRepository("whiteship/live-study")
    val issue = repository.getIssue(30)

    val studyDashboard: StudyDashboard = StudyDashboard()
    studyDashboard.studyReviews(issue)
    studyDashboard.usernames.forEach{ println(it) }
    studyDashboard.reviews.forEach{ println(it) }

}