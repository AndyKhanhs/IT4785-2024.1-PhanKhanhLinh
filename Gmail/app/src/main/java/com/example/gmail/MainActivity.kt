package com.example.gmail

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sampleData = listOf(
            ListItem(senderName = "John Doe", content = "Meeting Reminder: Project Kickoff scheduled for next Monday at 10 AM in the main conference room. Please come prepared with your project updates.", time = "Yesterday, 3:45 PM", isLike = false),
            ListItem(senderName = "Jane Smith", content = "Your Invoice is Ready: The invoice for your recent purchase is now available for download. Please review the details and let us know if you have any questions.", time = "Oct 26, 10:00 AM", isLike = true),
            ListItem(senderName = "Mike Johnson", content = "Weekly Team Update: This week's update includes important information regarding project timelines and deliverables. Please ensure you check your email regularly.", time = "Oct 25, 1:30 PM", isLike = false),
            ListItem(senderName = "Sara Connor", content = "Invitation to Company Event: We are excited to invite you to our annual company event. It will be held on Friday at 6 PM, and we look forward to seeing you there!", time = "Oct 24, 4:15 PM", isLike = true),
            ListItem(senderName = "Tom Hanks", content = "Don't Forget Our Lunch Tomorrow: Just a quick reminder about our lunch meeting scheduled for tomorrow at noon. Looking forward to discussing the new project!", time = "Oct 23, 12:00 PM", isLike = false),
            ListItem(senderName = "Alice Cooper", content = "New Features Available in the App: We have rolled out some exciting new features in the app. Be sure to check them out and let us know your feedback!", time = "Oct 22, 9:30 AM", isLike = true),
            ListItem(senderName = "Bob Marley", content = "Feedback Request on Recent Changes: We value your input and would love to hear your thoughts on the recent changes made to the platform. Your feedback is crucial for us to improve.", time = "Oct 21, 5:00 PM", isLike = false),
            ListItem(senderName = "Eve Adams", content = "Your Subscription Has Been Renewed: This is to confirm that your subscription has been successfully renewed for another year. Thank you for being a loyal customer!", time = "Oct 20, 11:45 AM", isLike = true),
            ListItem(senderName = "Grace Hopper", content = "Let's Catch Up Soon: It's been a while since we last met! I would love to catch up and hear what you've been up to. Let me know your availability.", time = "Oct 19, 8:30 AM", isLike = false),
            ListItem(senderName = "Henry Ford", content = "Check Out Our Latest Offers: We have some amazing offers available this week. Don’t miss out on the opportunity to grab the best deals before they end!", time = "Oct 18, 6:00 PM", isLike = true)
        )

        val listView: ListView = findViewById(R.id.listView)
        val adapter = CustomAdapter(this, sampleData)
        listView.adapter = adapter
    }
}