#include<bits/stdc++.h>
using namespace std;
class Info{
    public:
    string driver_name;
    int rating;
    string customer_name;
};
class Driver{
    public:
    map <string,int> drivermap;
    map <string,int> ::iterator it;
    vector <Info> drivers;
    void check_driver(string dname){
        it  = drivermap.find(dname);
        if(it == drivermap.end()){
            drivermap[dname] = 0;
        }
    }
    void update_drating(string dname,int drating,string cname){
        check_driver(dname);
        it  = drivermap.find(dname);
        drivermap[dname] = drivermap[dname]+drating;
        drivers.push_back({dname,drating,cname});
    }
 
    
};
class Customer{
    public:
    map <string,int> customermap;
    map <string,int> ::iterator it;
    vector <Info> customers;
    void check_customer(string cname){
        it  = customermap.find(cname);
        if(it == customermap.end()){
            customermap[cname] = 0;
        }
    }
    void update_crating(string cname,int crating,string dname){
        check_customer(cname);
        it  = customermap.find(cname);
        customermap[cname] = customermap[cname]+crating;
        customers.push_back({cname,crating,dname});
    }
    
};

class Trip:public Driver,public Customer{
    public:
    void addTrip(string dname,int drating,string cname,int crating){
        cout<<dname<<" "<<drating<<" "<<cname<<" "<<crating<<endl;
        update_drating(dname,drating,cname);
        update_crating(cname,crating,dname);
    }

};

int main(){
    Trip trip_id[10];
    string drivers_name[] = {"d1","d1","d1","d2","d2","d2","d3","d3","d3"};
    int drivers_rating[] = {4,5,1,5,5,4,3,4,3};
    string customers_name[] = {"c1","c2","c3","c1","c2","c3","c1","c2","c3"};
    int customers_rating[] = {5,4,2,1,5,5,2,5,3};
    for(int index = 0;index<9;index++){
        trip_id[index].addTrip(drivers_name[index],drivers_rating[index],customers_name[index],customers_rating[index]);
    }
    
    return 0;
}