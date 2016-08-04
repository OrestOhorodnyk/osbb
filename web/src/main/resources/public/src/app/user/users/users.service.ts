import {Injectable} from "@angular/core";
import {userItem} from "./userItem";
import {Http, Headers, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/toPromise";

@Injectable()
export class UsersService {
    private _pathUrl='http://localhost:52430/restful/user/';
    constructor( private http:Http){
    }

    getAllUsers():Observable<any>{
        console.log('in service');
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.get(this._pathUrl,{headers:headers})
            .map(response => response.json());
    }

    updateUser(user:userItem):Observable<userItem>{
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post(this._pathUrl+user.userId,JSON.stringify(user),{headers:headers})
            .map((res:Response) => {return new userItem(res.json())});
    }
    deleteUser(user:userItem){
        return this.http.delete(this._pathUrl+user.userId)
            .map(response => response.json());
    }
}