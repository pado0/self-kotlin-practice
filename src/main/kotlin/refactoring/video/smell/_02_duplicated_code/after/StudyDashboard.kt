package refactoring.video.smell._02_duplicated_code.after

import org.kohsuke.github.GHIssue
import org.kohsuke.github.GitHub

class StudyDashboard {

    fun printParticipants(eventId: Int) {
        // 인라인으로 변경
        print(getUsernames(getIssue(eventId)))
    }

    fun printReviews() {
        // 인라인으로 변경
        print(getUsernames(getIssue(30)))
    }

    // 출력하는 함수 추출
    private fun print(participants: HashSet<String>) {
        participants.forEach { println(it) }
    }

    // username 가져오는 함수 추출
    private fun getUsernames(issue: GHIssue): HashSet<String> {
        val usernames = hashSetOf<String>()
        issue.comments.forEach { usernames.add(it.userName) }
        return usernames
    }

    // 이슈 가져오는 함수 추출
    private fun getIssue(eventId: Int): GHIssue {
        val gitHub = GitHub.connect()
        val repository = gitHub.getRepository("whiteship/live-study")
        return repository.getIssue(eventId)
    }
}

fun main() {

    val studyDashboard: StudyDashboard = StudyDashboard()
    studyDashboard.printReviews()
    studyDashboard.printParticipants(eventId = 15)

}