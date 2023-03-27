package refactoring.video.smell._02_duplicated_code.before

import org.kohsuke.github.GitHub

class StudyDashboard {

    fun printParticipants(eventId: Int) {

        val gitHub = GitHub.connect()
        val repository = gitHub.getRepository("whiteship/live-study")
        val issue = repository.getIssue(eventId)

        val participants = hashSetOf<String>()
        issue.comments.forEach{it -> participants.add(it.userName)}

        participants.forEach{ println(it) }
    }
    fun printReviews() {

        val gitHub = GitHub.connect()
        val repository = gitHub.getRepository("whiteship/live-study")
        val issue = repository.getIssue(30)

        val reviewrs = hashSetOf<String>()
        issue.comments.forEach{it -> reviewrs.add(it.userName)}

        reviewrs.forEach{ println(it) }
    }
}

fun main() {

    val studyDashboard: StudyDashboard = StudyDashboard()
    studyDashboard.printReviews()
    studyDashboard.printParticipants(eventId = 15)

}