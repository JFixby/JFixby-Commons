
package com.jfixby.scarabei.amazon.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.jfixby.scarabei.api.collections.Collection;
import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.aws.api.sqs.SQSMessage;

public class RedSQSReceiveMessageRequestResult implements com.jfixby.scarabei.aws.api.sqs.SQSReceiveMessageResult {

	private final ReceiveMessageResult aws_result;

	public RedSQSReceiveMessageRequestResult (final RedSQSReceiveMessageRequest request, final AmazonSQSClient awsSQSClient) {
		this.aws_result = awsSQSClient.receiveMessage(request.aws_request);

	}

	@Override
	public Collection<SQSMessage> listMessages () {
		final List<SQSMessage> result = Collections.newList();
		final java.util.List<Message> awsList = this.aws_result.getMessages();
		for (final Message m : awsList) {
			result.add(new RedSQSMessage(m));
		}
		return result;
	}

}
