package refactoring.smell._01_mysterius_name.before

import org.kohsuke.github.GHIssue
import org.kohsuke.github.GitHub

class StudyDashboard {

    val usernames = hashSetOf<String>()
    val reviews = hashSetOf<String>()

    /**
     * 스터디 리뷰 이슈에 작성되어있는 리뷰어 목록과 리뷰를 읽어오는 함수
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
    studyDashboard.usernames.forEach{ _ -> println() }
    studyDashboard.reviews.forEach{ _ -> println() }

}