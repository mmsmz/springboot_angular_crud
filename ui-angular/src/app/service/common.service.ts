import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient, HttpResponse ,HttpHeaders, HttpParams} from '@angular/common/http';
import { AuthService } from '../guard/auth.service';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  


  constructor(
    private http : HttpClient,
    private authService: AuthService
  ) { }

  userLogin(data){
    let credential = {
        username : data.username,
        password : data.password
    }
    
    return this.http.post<any>(`http://localhost:8084/authenticate`, credential);
  }

  // get isLoggedIn() {
  //   return this.loggedIn.asObservable();
  // }
  
  getTableData(){
    // let headers = new HttpHeaders({
    //   'Content-Type': 'application/json',
    //   'Accept': 'application/json'
    // });

    let loginToken = this.authService.getToken();
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + loginToken);

    return this.http.get<any>(`http://localhost:8084/getAllAdvertising`, {headers} );
  }

  createAdvertisment(data){
    let insertData =  {
      advertisingId: data.adId,
      vacancyName: data.adName,
      vacancyDescription: data.adDescription,
      vacancyType: data.Type,
      email: data.Email
    }

    let loginToken = this.authService.getToken();
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + loginToken);

    return this.http.post<any>(`http://localhost:8084/createAdvertising`,insertData, {headers});
  }

  deleteRecord(adId){
    let loginToken = this.authService.getToken();
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + loginToken);

    return this.http.delete(`http://localhost:8084/deleteAdvertising?advertisingId=${adId}`, {headers});
  }

  updateRecord(data){
    let insertData =  {
      advertisingId: data.adId,
      vacancyName: data.adName,
      vacancyDescription: data.adDescription,
      vacancyType: data.Type,
      email: data.Email
    }

    let loginToken = this.authService.getToken();
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + loginToken);

    return this.http.patch(`http://localhost:8084/updateAdvertising?advertisingId=${data.adId}`, insertData,{headers});
  }


  userRegisttration(data){
    let userDetails = {
      contactNumber: data.contact,
      email: data.email,
      password: data.password,
      userName: data.username,
    };

    return this.http.post(`http://localhost:8085/registration-service/saveUserRegistrationDetails`,userDetails);

  }

}
