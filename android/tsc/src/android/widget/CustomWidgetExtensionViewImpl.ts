// start - imports

	
import CommandAttr from '../../widget/CommandAttr';
import IWidget from '../../widget/IWidget';
import ILayoutParam from '../../widget/ILayoutParam';
import {plainToClass, Type, Exclude, Expose, Transform} from "class-transformer";
import 'babel-polyfill';
import {Gravity} from '../../widget/TypeConstants';
import {ITranform, TransformerFactory} from '../../widget/TransformerFactory';
import {Event} from '../../app/Event';
import {MotionEvent} from '../../app/MotionEvent';
import {DragEvent} from '../../app/DragEvent';
import {KeyEvent} from '../../app/KeyEvent';
import { ScopedObject } from '../../app/ScopedObject';




// end - imports
import {ViewImpl} from './ViewImpl';
export abstract class CustomWidgetExtensionViewImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "linearGradientBackground" })
	linearGradientBackground!:CommandAttr<string>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.linearGradientBackground = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setLinearGradientBackground(value : string) : T {
		this.resetIfRequired();
		if (this.linearGradientBackground == null || this.linearGradientBackground == undefined) {
			this.linearGradientBackground = new CommandAttr<string>();
		}
		
		this.linearGradientBackground.setSetter(true);
		this.linearGradientBackground.setValue(value);
		this.orderSet++;
		this.linearGradientBackground.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class CustomWidgetExtensionView extends CustomWidgetExtensionViewImpl<CustomWidgetExtensionView> implements IWidget{
    getThisPointer(): CustomWidgetExtensionView {
        return this;
    }
    
   	public getClass() {
		return CustomWidgetExtensionView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

CustomWidgetExtensionViewImpl.initialize();

//end - staticinit
