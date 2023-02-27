import { Observable } from "rxjs";
import { ITanks } from "./i-tanks";

export interface HttpCrudInterface {
    getdata():Observable<ITanks>;
}
