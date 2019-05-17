package com.apifortress.mule.apifpullpush;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;

public class CachedFilterProcessor implements MessageProcessor {

	@Override
	@SuppressWarnings("rawtypes")
	public MuleEvent process(MuleEvent event) throws MuleException {
		
		ArrayList data = (ArrayList) event.getMessage().getPayload();
		System.out.println(data.getClass().getSimpleName());
		Iterator iterator = data.iterator();
		while(iterator.hasNext()) {
			Map it = (Map)iterator.next();
			System.out.println(it.get("_id"));
		}
		return event;
	}

}
