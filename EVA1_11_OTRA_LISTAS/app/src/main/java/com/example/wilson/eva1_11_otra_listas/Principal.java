package com.example.wilson.eva1_11_otra_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener{

    ListView lstVwTitu;
    TextView txtVwMuestra;
    final String[] timeline = {
            "32 BBY: The Phantom Menace",
            "22 BBY: Attack of the Clones",
            "19 BBY: Revenge of the Sith",
            "12 BBY: Solo",
            "0 BBY: Rogue One",
            "Year 0: Star Wars",
            "3 ABY: The Empire Strikes Back",
            "4 ABY: Return of the Jedi",
            "34 ABY: The Force Awakens",
            "34 ABY: The Last Jedi"
    };

    final String[] excerpt = {"The Trade Federation upsets order in the Galactic Republic by blockading the planet Naboo in preparation for a full-scale invasion. The Republic's leader, Supreme Chancellor Valorum, dispatches Jedi Master Qui-Gon Jinn, and his apprentice, Obi-Wan Kenobi, to negotiate with the Trade Federation Viceroy, Nute Gunray. Darth Sidious, a Sith Lord and the Trade Federation's secret benefactor, orders the Viceroy to kill the Jedi and begin their invasion with an army of battle droids. The Jedi escape and flee to Naboo. During the invasion, Qui-Gon saves the life of a clumsy Gungan outcast, Jar Jar Binks, from being run over and killed by a droid transport. Indebted to Qui-Gon, Jar Jar leads the Jedi to Otoh Gunga; an underwater Gungan city. The Jedi unsuccessfully try to persuade the Gungan leader, Boss Nass, into helping the people of Naboo; but he is not interested due to disliking the humans on the surface. However, the Jedi do manage to obtain underwater transport to Theed, the capital city on the surface, narrowly avoiding getting eaten by sea monsters on the way. They rescue Queen Padmé Amidala, the ruler of the Naboo people, and escape from the blockaded planet on her Royal Starship en route to the Republic capital planet of Coruscant.",
    "Ten years after the Trade Federation's invasion of Naboo, the Galactic Republic is threatened by the Separatist movement organized by former Jedi Master Count Dooku. Senator Padmé Amidala comes to Coruscant to vote on a motion to create an army to assist the Jedi against this threat. Narrowly avoiding an assassination attempt upon arrival, she is placed under the protection of Jedi Master Obi-Wan Kenobi and his apprentice, Anakin Skywalker. The two Jedi thwart a second attempt on her life and subdue the assassin, Zam Wesell, a shape-shifter who is soon killed by her bounty hunter client before she can reveal his identity. The Jedi Council assigns Obi-Wan to identify and capture the bounty hunter, while Anakin is assigned to escort Padmé back to Naboo, where the pair soon fall in love and begin a relationship.",
    "Three years after the Battle of Geonosis, the galaxy is in a state of civil war. During a space battle over Coruscant, Jedi master Obi-Wan Kenobi and Jedi Knight Anakin Skywalker lead a mission to rescue the kidnapped Supreme Chancellor Palpatine from the cyborg Separatist commander, General Grievous. After infiltrating Grievous's flagship, the Invisible Hand, the Jedi battle Count Dooku, whom Anakin eventually executes at Palpatine's urging. Grievous escapes the battle-torn cruiser in the last remaining escape pod, in which the Jedi are forced to crashland the Invisible Hand on Coruscant. There, Anakin reunites with his wife, Padmé Amidala, who reveals that she is pregnant. While initially excited, Anakin begins to have prophetic visions of Padmé dying in childbirth, and his worry steadily grows.\n" +
            "\n" +
            "Palpatine appoints Anakin to the Jedi Council as his representative and informant, but the Council declines to grant Anakin the rank of Jedi Master and orders him to spy on Palpatine, causing Anakin's faith in the Jedi to diminish significantly. Palpatine tempts Anakin with secret knowledge of the dark side of the Force, including the \"power to save his loved ones from dying\". Meanwhile, Obi-Wan travels to Utapau, where he finds and kills General Grievous, and Yoda travels to Kashyyyk to defend the planet from Separatist invasion. Palpatine eventually reveals to Anakin that he is the Sith Lord, Darth Sidious, saying that only he has the knowledge to save Padmé from dying. Torn between staying loyal to the Jedi Order and saving Padmé's life, Anakin reports Palpatine's treachery to Mace Windu, who confronts and subdues Palpatine, severely disfiguring him in the process. Fearing that he will lose Padmé, Anakin intervenes on Palpatine's behalf and severs Windu's hand, allowing Palpatine to throw him out of a window to his death using force lightning. Anakin pledges himself to Palpatine, who dubs him Darth Vader. Palpatine issues Order 66 for the clone troopers to kill the remaining Jedi, and dispatches Vader along with a band of clones to kill everyone in the Jedi Temple on Coruscant. Vader then massacres the remaining Separatist leaders hiding on the volcanic planet Mustafar, who are not expecting his arrival. Meanwhile, Palpatine addresses the Galactic Senate; transforming the Republic into the Galactic Empire and declaring himself Emperor. Having survived the chaos, Obi-Wan and Yoda return to Coruscant and learn of Anakin's betrayal.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lstVwTitu = findViewById(R.id.lstVwTitu);
        txtVwMuestra = findViewById(R.id.txtVwMuestra);
        lstVwTitu.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timeline)
        );

        lstVwTitu.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        txtVwMuestra.setText(excerpt[i]);
    }
}
