import {
  Component,
  OnInit,
  OnDestroy,
  Output,
  EventEmitter,
  Input,
} from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { IPatrol } from 'src/app/interfaces/ipatrol';
import { IPeople } from 'src/app/interfaces/ipeople';

@Component({
  selector: 'week-duty-form',
  templateUrl: 'week-duty-form.component.html',
  styleUrls: ['week-duty-form.component.scss'],
})
export class WeekDutyFormComponent implements OnInit, OnDestroy {
  public formGroup!: FormGroup;
  @Input() public model: any = {};
  @Input() public allpeoples!: IPeople[];
  @Output() public onSub: EventEmitter<IPatrol> = new EventEmitter<IPatrol>();
  dateNow: Date = new Date();
  time!: string;
  constructor(private fb: FormBuilder) {}
  onSubmit() {
    if (this.formGroup.status == 'VALID') {
      const newPost: IPatrol = {
        name: this.formGroup.value.PIB,
        start: `${
          this.formGroup.value.start_time
        } ${this.formGroup.value.start_date.toLocaleDateString('en-US')}`,
        endd: `${
          this.formGroup.value.end_time
        } ${this.formGroup.value.end_date.toLocaleDateString('en-US')}`,
        status: false,
      };
      this.onSub.emit(newPost);
    }
  }
  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.formGroup = this.fb.group({
      PIB: [this.model.PIB, [Validators.required]],
      start_date: [this.model.start_date, [Validators.required]],
      start_time: [this.model.start_time, [Validators.required]],
      end_date: [this.model.end_date, [Validators.required]],
      end_time: [this.model.end_time, [Validators.required]],
    });
  }
  // convenience getter for easy access to form fields
  get f(): any {
    return this.formGroup.controls;
  }

  addItem(formArrayName: string) {
    this.f[formArrayName].push(this.fb.control(''));
  }

  deleteItem(formArrayName: string, index: number) {
    this.f[formArrayName].removeAt(index);
  }

  ngOnDestroy() {}
}
