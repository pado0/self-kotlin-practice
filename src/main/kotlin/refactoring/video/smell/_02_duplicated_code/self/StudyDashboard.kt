package refactoring.video.smell._02_duplicated_code.self

import org.kohsuke.github.GHIssue
import org.kohsuke.github.GitHub

class StudyDashboard {

    fun printParticipants(eventId: Int) {

        val issue = getIssue(eventId)
        val participants = hashSetOf<String>()
        issue.comments.forEach{it -> participants.add(it.userName)}
        participants.forEach{ println(it) }
    }
    fun printReviews() {

        val issue = getIssue(30)
        val reviewrs = hashSetOf<String>()
        issue.comments.forEach{it -> reviewrs.add(it.userName)}
        reviewrs.forEach{ println(it) }
    }

    // 공통 함수 추출
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