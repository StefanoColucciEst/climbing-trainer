import { useParams } from 'react-router-dom'
import { useGrip, useAssessments } from '../../hooks/useGrips'
import { PageHeader } from '../../components/layout/PageHeader'
import { AssessmentCard } from '../../components/ui/AssessmentCard'

const FINGER_SHORT: Record<string, string> = {
  THUMB: 'Th', INDEX: 'I', MIDDLE: 'M', RING: 'R', PINKY: 'P'
}

export function GripDetailPage() {
  const { id } = useParams<{ id: string }>()
  const gripId = Number(id)
  const { data: grip, isLoading: gripLoading } = useGrip(gripId)
  const { data: assessments, isLoading: assessLoading } = useAssessments(gripId)

  if (gripLoading || assessLoading) return <div className="py-8 text-center text-text-secondary">Loading...</div>
  if (!grip) return <div className="py-8 text-center text-text-secondary">Grip not found</div>

  return (
    <div>
      <PageHeader title={grip.name} />

      <div className="bg-card rounded-2xl p-4 shadow-sm mb-4">
        <div className="grid grid-cols-2 gap-3 text-sm">
          <div>
            <span className="text-text-secondary">Category</span>
            <p className="font-semibold">{grip.category}</p>
          </div>
          <div>
            <span className="text-text-secondary">Hand Mode</span>
            <p className="font-semibold">{grip.handMode.replace(/_/g, ' ')}</p>
          </div>
          <div>
            <span className="text-text-secondary">Grip Type</span>
            <p className="font-semibold">{grip.gripType.replace(/_/g, ' ')}</p>
          </div>
          <div>
            <span className="text-text-secondary">Edge</span>
            <p className="font-semibold">{grip.edgeDepthMm}mm {grip.edgeType.toLowerCase()}</p>
          </div>
          <div className="col-span-2">
            <span className="text-text-secondary">Fingers</span>
            <p className="font-semibold">{grip.fingers.map(f => FINGER_SHORT[f] || f).join(', ')}</p>
          </div>
        </div>
      </div>

      <h2 className="text-xs font-semibold text-text-secondary uppercase tracking-wide mb-3 mt-6">Assessments</h2>
      {assessments && assessments.length > 0 ? (
        assessments.map(a => <AssessmentCard key={a.id} assessment={a} />)
      ) : (
        <p className="text-sm text-text-secondary">No assessments yet</p>
      )}
    </div>
  )
}
