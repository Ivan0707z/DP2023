import { Observable } from "rxjs";
import { ITanks } from "./i-tanks";

export interface HttpCrudInterface {
    doGet():Observable<ITanks[]>;
    doPut(body:ITanks):Observable<ITanks>;
    doPost(body:ITanks):Observable<ITanks>;
    doDel(body:ITanks):Observable<ITanks[]>;
}
