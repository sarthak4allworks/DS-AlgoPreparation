

#include <bits/stdc++.h>
using namespace std; 

class Player {
	public:
	string playerName , profile; 
	int runScored , wickets, catches, stumping , runOuts, maiden ,oversBowled , runConcluded;
    int points;
	Player (string playerName, string profile) 
    	//int runScored , int  wickets, int catches, int stumping , int runOuts, int maiden , int oversBowled , int runConcluded )
    {
    	 this->playerName = playerName ;
    	 this->profile = profile ; 
    	
    }

    addMatchDetails ( int runScored , int  wickets, int catches, int stumping , int runOuts, int maiden , int oversBowled , int runConcluded )
    {
    	 this->runScored = runScored ; 
    	 this->wickets = wickets ; 
    	 this->catches = catches ; 
    	 this->stumping = stumping ;
    	 this->runOuts = runOuts ;
    	 this->maiden = maiden ; 
    	 this->oversBowled = oversBowled ;
    	 this->runConcluded = runConcluded ;  
    }

    int getBowlingPoints()
    {
    	int point = 0 ; 
    	point += ( wickets / 2 ) * 20 ;
    	point += ( wickets % 2 ) * 5 ; 
    	point += maiden * 2 ; 
    	return point ; 
    }
    int getBattingPoints ()
    {
    	int point = 0 ;
    	point += ( runScored / 20 ) * 15 ;
    	point += ( ( runScored % 20 ) / 10 ) * 2 ;
    	return point ; 
    }

    int getFieldingPoints()
    {
    	int point = 0 ; 
    	point += catches * 2 ;
    	point += runOuts * 2 ;
    	point += stumping * 2 ;    	
    }
    int getPoints ()
    {
    	int point = 0 ;
    	// batting  
    	point += getBattingPoints();
  
    	// bowling
        point += getBowlingPoints(); 	
   
    	// fielding 
        point += getFieldingPoints () ;

		this->points = point ; 
	    return point;
	}

};
map < string ,int> series ; 
map < string , vector < Player> > teamMap ; 
vector < Player> playerList;

string highestRun ()
{
	int highestTill = 0; 
	string playerName = "" ;
	for ( int i = 0 ;i < playerList.size () ; ++i )
	{
		if (  playerList[i].runScored > highestTill )
		{
			highestTill  = playerList[i].runScored ; 
			playerName = playerList[i].playerName ; 
		}
	}
	return playerName ;
}

string highestWicket ( )
{
	int highestTill = 0; 
	string playerName = "" ;
	int index = 0 ;
	for ( int i = 0 ;i < playerList.size () ; ++i )
	{
		if (  playerList[i].wickets > playerList[index].wickets )
		{
			 index = i ; 
		}
		else  if ( playerList[i].wickets == playerList[index].wickets && playerList[i].runConcluded  < playerList[index].runConcluded )
		{
			index = i;
		}
	}
	return playerList[index].playerName ;	
}

string ManOftheMatch( string teamName )
{

	vector < Player> players  = teamMap [teamName] ;

	int highestTill = 0; 
	string playerName = "" ;
	for ( int i = 0 ;i < players.size () ; ++i )
	{
		if (  playerList[i].getPoints() > highestTill )
		{
			highestTill  = playerList[i].points; 
			playerName = playerList[i].playerName ; 
		}
	}
	return playerName ;	
}
string manOftheSeries ()
{
	string playerNme = "" ;
	int highestTill = 0 ;
	for ( map < string, int> :: iterator it = series.begin() ;it != series.end() ; ++it )
	{
		if ( it->second > highestTill )
		{
			highestTill = it->second ; 
			playerNme = it->first ; 
		}
	}
	return playerNme; 
}

void solve ( int matchId , string playerName, string profileName, string teamName,
    int runScored , int  wickets, int catches, int stumping , int runOuts, int maiden , int oversBowled , int runConcluded)
{
    /*Player *tmpPlayer ;
	 //int runScored , int wickets,  int catches, int stumping , int runOuts, int maiden , int oversBowled , int runConcluded);
    for ( int i = 0 ;  i < playerList.size() ; i++)
    {
    	if ( playerList[i].playerName == playerName )  {
    		tmpPlayer = &playerList[i] ;
    		break; 
    	} 
    }
    if ( tmpPlayer == NULL )
    {
    	tmpPlayer = new Player( playerName, profile);	
    }   */
    
    //tmpPlayer->addMatchDetails(runScored , wickets,  catches, stumping , runOuts, maiden , oversBowled , runConcluded);  

	Player tmpPlayer( playerName , profileName );
    tmpPlayer.addMatchDetails(runScored , wickets,  catches, stumping , runOuts, maiden , oversBowled , runConcluded);  
	playerList.push_back ( tmpPlayer ) ; 
	if ( teamMap.count(teamName) )
	{
		teamMap[teamName].push_back ( tmpPlayer ) ; 
	}	
	else 
	{
		vector < Player > playerList ;
		playerList.clear () ; 
		playerList.push_back( tmpPlayer ) ; 
		teamMap[teamName] = playerList ;  
	}
    
    series[playerName] += tmpPlayer.getPoints();
}  
int getBowling ( string teamName )
{
	vector < Player> tmpP;
	if ( teamName == "india" )
	{
		tmpP = teamMap["india"] ; 		
	}
	else  tmpP = teamMap["aus"]; 
	int bowlingPoints = 0 ; 
	for ( int i = 0; i < tmpP.size (); ++i )
	{
		bowlingPoints += tmpP[i].getBowlingPoints(); 
	}
	return bowlingPoints ; 
}

int getBatting( string teamName )
{
	vector < Player> tmpP;
	if ( teamName == "india" )
	{
		tmpP = teamMap["india"] ; 		
	}
	else tmpP = teamMap["aus"] ; 
	int battingPoints = 0 ; 
	for ( int i = 0; i < tmpP.size () ; ++i)
	{
		battingPoints += tmpP[i].getBattingPoints(); 
	}
	return battingPoints ; 

}

int totalPoints( string teamName )
{
	vector < Player> tmpP;
	if ( teamName == "india" )
	{
		tmpP = teamMap["india"] ; 		
	}
	else tmpP = teamMap["aus"] ; 
	int totalPoints = 0 ; 
	for ( int i = 0; i < tmpP.size () ; ++i)
	{
		totalPoints += tmpP[i].getPoints(); 
	}
	return totalPoints ; 
}

//void solve ( )

int main () 
{
	string playerName, profile, teamName;
	int runScored , wickets, catches, stumping , runOuts, maiden ,oversBowled , runConcluded;
	
	string pitchSurface ;
	int numMatches ; 
	freopen("in.in" , "r" , stdin ) ; 
	cin >> numMatches ;
	
	for ( int matchId = 1 ; matchId <= numMatches ; matchId ++)
	{
		int playerDetails ;
		cin >> playerDetails;
		cin >> pitchSurface; 
		
		int indiaScore = 0 , otherScore = 0 ;
		int indiaWickets = 0 , otherWickets = 0 ;
		teamMap.clear();
		playerList.clear (); 
		string firstTeam = "" ; 
		while ( playerDetails--   ){
		    
			cin >> playerName >> profile >> teamName ;
			cin >> runScored >> wickets >> catches >> stumping >> runOuts >> maiden >> oversBowled >> runConcluded;
			if ( teamName == "india" )  {
				indiaScore += runScored ;
				indiaWickets += wickets;
			} 
			else    {               
				otherScore += runScored  ; 
				otherWickets += wickets ;
			}
            
			
			//cout << indiaWickets <<" " << otherWickets << endl;
			solve (  matchId, playerName ,profile , teamName, runScored , wickets,  catches, stumping , runOuts, maiden , oversBowled , runConcluded);
		    if ( firstTeam == "" )
		    {
		    	firstTeam = teamName ;
		    }
		}
        //cout << indiaScore <<" " << otherScore << endl;
	    	if( indiaScore > otherScore && firstTeam == "india" )
		{
			cout << "India won the game by " << ( indiaScore - otherScore) << " runs!!\n";
			cout << ManOftheMatch( "india" ) <<" was declared the man of the match\n";
			//printf(" India batting first, won the game by %d runs!! %d was declared man of the match %d was the highest run scorer %d bowled the best); 
		}
		else if ( otherScore > indiaScore && firstTeam != "india"  )
		{
			cout <<"Australia won the game by " <<( otherScore -indiaScore ) <<" runs!!\n" ;
			cout << ManOftheMatch("aus" ) <<" was declared the man of the match\n";
		}
		else if ( otherScore > indiaScore && firstTeam == "india" )
		{
			cout <<"Australia chased the game succesfully and won by " <<( 5 - indiaWickets ) <<" wickets!!\n" ;
			cout << ManOftheMatch("aus" ) <<" was declared the man of the match\n";
		
		}
		else if( indiaScore > otherScore && firstTeam != "india" )
		{
			cout <<"India chased the game succesfully and won by " <<( 5 - otherWickets) <<" wickets!!\n" ;
			cout << ManOftheMatch("india" ) <<" was declared the man of the match\n";
		}
		else 
		{
			cout <<"tie"<<endl ;
			cout << ManOftheMatch(firstTeam ) <<" was declared the man of the match\n";
		}
		
	    cout << ManOftheMatch(firstTeam ) <<" was declared the man of the match\n";
		cout << highestRun() <<" was the highest run Scorer\n";
		cout << highestWicket () << " bowled the best\n";
		cout << endl; 
		bool bonus = true; 
		if ( bonus )
		{
		    int indiaBatting = getBatting ("india") ; 
		    int ausBatting  = getBatting("aus");
		    int indiaBowling = getBowling("india");
		    int ausBowling = getBowling("aus");
		    int indiaTotal = totalPoints("india");
		    int ausTotal = totalPoints ("aus");
		    //int indiScore = 0 , ausiScore = 0 ; 

		    if( indiaTotal >= ausTotal )
		    {
		    	if ( pitchSurface == "batting" )
		    	{
		    		indiaTotal += 20; 
		    	}
		    	else   ausTotal += 20; 
		    }

		    else 
		    {
		    	if( pitchSurface == "batting")
		    	{
		    		ausTotal += 20 ;
		    	}
		    	else    indiaTotal += 20; 
		    }
		    
		    
		    if ( pitchSurface == "batting" ) 
	    	{ 
	    	 		indiaTotal += indiaBatting ; 
	    	 		ausTotal += ausBatting ; 
	    	}
	    	else        
	    	{
	    	 	  ausTotal += ausBowling ; 
	    	 	  indiaTotal += indiaBowling ; 
	    	}
            
            cout << indiaTotal <<" " << ausTotal << endl;
            if ( indiaTotal > ausTotal )
            {
            	 cout <<"india may win the next match\n\n" ; 
            }
            else if ( ausTotal > indiaTotal )
            {
            	cout <<"aus may win the next match\n\n";
            }
            else 
            {
            	 cout <<"can't predict\n\n ";
            }
	   }
	}
	cout <<"man of the series is: " << manOftheSeries () << endl;
}
